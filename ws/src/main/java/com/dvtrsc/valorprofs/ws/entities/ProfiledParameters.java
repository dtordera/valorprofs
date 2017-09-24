package com.dvtrsc.valorprofs.ws.entities;

import java.sql.CallableStatement;
import java.sql.SQLException;

/*
 * ProfiledParameters. Derived classes collects from validateaccess call profile id, used later in request actions  
 */
public abstract class ProfiledParameters extends ValidateAccessParameters
{
	public long profile;
	  
	public CallableStatement mapParameters(CallableStatement cs) throws SQLException
	{
	    cs.setLong(1, this.profile);
	    return cs;
	}
}
