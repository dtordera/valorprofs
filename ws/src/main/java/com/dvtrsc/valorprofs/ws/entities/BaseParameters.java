package com.dvtrsc.valorprofs.ws.entities;

import java.sql.CallableStatement;
import java.sql.SQLException;

/*
 * BaseParameters : main parameter class. Derived classes must implement mapping method, called in DBBaseResponse before petition to DB server 
 */

public abstract class BaseParameters
{
	public abstract CallableStatement mapParameters(CallableStatement paramCallableStatement) throws SQLException;
}
