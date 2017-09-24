package com.dvtrsc.valorprofs.ws.entities;

import com.dvtrsc.valorprofs.ws.db.DBController;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/*
 * BaseResource: base class for published resources. 
 */

public abstract class BaseResource
{
	static final Logger logger = Logger.getLogger(BaseResource.class);
  
	// answerToRequest. Main method to be called from derived resource. 
	protected <T extends ProfiledParameters, R extends BaseResponse> Response answerToRequest(T Q, RequestAction<R, T> N)
	    throws JsonGenerationException, JsonMappingException, IOException
	{
		// check if user, hash, originaddress & salt are valid
	    checkAccessParams(Q);
	    
	    // attempts to validate access, making an independent call to DB
	    ValidateAccessResponse A = DBController.doValidateAccess(Q.getAsValidateAccessParameters());
	    
	    // if ok, gets the profile (if failed, profile = 0)
	    Q.profile = A.profile;
	    
	    // case of error, return; if not, execute indicated action
	    return A.rc != 0 ? FailedResponse(A) : WithAccessResponse(N.doAction(Q));
	}
  
	// helper classes to manage responses depending on error 
	protected Response WithAccessResponse(BaseResponse R)
	    throws JsonGenerationException, JsonMappingException, IOException
	{
	    return R.rc == 0 ? 
	      Response.ok(new ObjectMapper().writeValueAsString(R)).build() : 
	      FailedResponse(R);
	}  
	protected Response FailedResponse(BaseResponse R)
	    throws JsonGenerationException, JsonMappingException, IOException
	{
	    return Response.serverError().entity(new ObjectMapper().writeValueAsString(R)).build();
	}
  
	// assignParams : maps request params from payload to an object in payloaded verbs (POST, PUT)
	protected <T extends ValidateAccessParameters> T assignParams(String payload, Class<T> paramClass)
	    throws IOException
	{
	    logger.info(getSelf() + " called with " + normalized(payload) + " payload");	    
	    return (T)new ObjectMapper().readValue(payload, paramClass);
	}
  
	// assignParams : maps request params from queryparams to an object in non-payloaded verbs (DELETE, GET)
	protected <T extends ValidateAccessParameters> T assignParams(MultivaluedMap<String, String> queryparams, Class<T> paramClass)
	    throws InstantiationException, IllegalAccessException
	{
	    logger.info(getSelf() + " called with " + normalized(queryparams.toString()) + " path parameters");
	    T params = (T)paramClass.newInstance();
	    params.assign(queryparams);
	    return params;
	}
  
	// basic access params validation
	protected <T extends ValidateAccessParameters> void checkAccessParams(T params) throws InvalidParameterException
	{
	    if (params.hash == null) throw new InvalidParameterException("Hash required");
	    if (params.user == null) throw new InvalidParameterException("No user informed");
	    if (params.salt == 0L) throw new InvalidParameterException("No salt informed");
	    if ((params.originaddress == null) || (!isIpAddress(params.originaddress))) 
	      throw new InvalidParameterException("Invalid origin address format");
	}

	// utility functions
	protected String getSelf()
	{
	    return getClass().getName() + " (" + String.format("%010d", new Object[] { Integer.valueOf(hashCode()) }) + ")";
	}  
	protected static String normalized(String s)
	{
	    return s.replace("\n", "").replace("\r", "").replace("\t", "").trim();
	}  
	private static Pattern VALID_IPV4_PATTERN = null;
	private static Pattern VALID_IPV6_PATTERN = null;
	@SuppressWarnings("unused")
	private static final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
	@SuppressWarnings("unused")
	private static final String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
  
	static
	{
	    try
	    {
	      VALID_IPV4_PATTERN = Pattern.compile("(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])", 2);
	      VALID_IPV6_PATTERN = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}", 2);
	    }
	    catch (PatternSyntaxException localPatternSyntaxException) {}
	}
  
	public static boolean isIpAddress(String ipAddress)
	{
	    Matcher m1 = VALID_IPV4_PATTERN.matcher(ipAddress);
	    if (m1.matches()) {
	      return true;
	    }
	    Matcher m2 = VALID_IPV6_PATTERN.matcher(ipAddress);
	    return m2.matches();
	}
}
