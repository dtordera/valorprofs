package com.dvtrsc.valorprofs.ws.entities;

import java.sql.CallableStatement;
import java.sql.SQLException;

/*
 * BaseResponse: base class for responses. Derived classes will be filled in DBBaseController, 
 * according to its methods implementation. As every procedure will return rc (resultcode), this OUT parameter is mapped & collected here. 
 */
public abstract class BaseResponse
{
	public int rc;

	// called in DBBaseController just before executing query, preparing result code
	public void registerOUTparameters(CallableStatement cs)	throws SQLException
	{
	    cs.registerOutParameter("rc", 4);
	}
  
	// called in DBBaseController after executing query, collecting result code
	public void mapResponseFromResult(CallableStatement cs) throws SQLException
	{
	    this.rc = cs.getInt("rc");
	}
}
