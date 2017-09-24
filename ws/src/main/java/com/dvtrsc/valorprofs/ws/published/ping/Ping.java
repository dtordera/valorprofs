package com.dvtrsc.valorprofs.ws.published.ping;

import com.dvtrsc.valorprofs.ws.entities.BaseResource;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
/*
 * Ping. check API method (access validation is not needed) 
 */
@Path("ping")
public class Ping extends BaseResource
{
	@GET
	@Produces({"application/json"})
	public Response getPing(@QueryParam("e") String e) throws JsonGenerationException, JsonMappingException, IOException
	{
		return WithAccessResponse(new PingResponse(e));
	}
}