package com.dvtrsc.valorprofs.ws.entities;

import java.sql.CallableStatement;
import java.sql.SQLException;
/*
 * ValidateAccessResponse. Response of validateaccess will deliver the profile id who is trying to realize the requested action
 */
public class ValidateAccessResponse extends BaseResponse
{
	public int profile;
  
	public void registerOUTparameters(CallableStatement cs) throws SQLException
	{
		super.registerOUTparameters(cs);
		cs.registerOutParameter("profile", 4);
	}
  
	public void mapResponseFromResult(CallableStatement cs)	throws SQLException
	{
		super.mapResponseFromResult(cs);
		this.profile = cs.getInt("profile");
	}
}
