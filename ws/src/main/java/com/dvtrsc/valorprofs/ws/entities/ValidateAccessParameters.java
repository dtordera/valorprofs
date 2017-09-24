package com.dvtrsc.valorprofs.ws.entities;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.ws.rs.core.MultivaluedMap;

/*
 * ValidateAccessParameters. Store credential parameters (user,hash,salt,originaddress) used in 
 * all requests which need authentication against DB (all except PING & RESULTCODES), and is used
 * to validate access in an automatic way on BaseResource.
 */

public class ValidateAccessParameters extends BaseParameters
{
	public String user;			// login
	public String hash;			// sha2(sha2(salt) + sha2(pwd))
	public long salt;			// unix timestamp
	public String originaddress;// origin IP address
  
	// map values from queryparameters in non-payload petitions 
	// (in payloaded petitions comes inside JSON payload itself, and then mapping it's inmediate)
	
	public void assign(MultivaluedMap<String, String> ss)
	{
	    this.hash = ((String)ss.getFirst("h"));
	    this.originaddress = ((String)ss.getFirst("o"));	    
	    try
	    {
	      this.salt = Integer.parseUnsignedInt((String)ss.getFirst("s"));
	    }
	    catch (NumberFormatException ex)
	    {
	      this.salt = 0L;
	    }
	    try
	    {
	      this.user = ((String)ss.getFirst("u"));
	    }
	    catch (NullPointerException localNullPointerException) {}
	}
  
	// Prepare validate access call, the unique procedure this general class will call
	public CallableStatement mapParameters(CallableStatement cs) throws SQLException
	{
	    cs.setString(1, this.user);
	    cs.setLong(2, this.salt);
	    cs.setString(3, this.hash);
	    cs.setString(4, this.originaddress);
	    
	    return cs;
	}
  
	// gets a clone from derived-class parameter object, just to not disturb with casting
	public ValidateAccessParameters getAsValidateAccessParameters()
	{
	    ValidateAccessParameters V = new ValidateAccessParameters();
	    
	    V.hash = this.hash;
	    V.salt = this.salt;
	    V.user = this.user;
	    V.originaddress = this.originaddress;
	    
	    return V;
	}
}