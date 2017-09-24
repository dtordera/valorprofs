package com.dvtrsc.valorprofs.ws.entities;

import com.dvtrsc.valorprofs.ws.db.DBConnectionPool;
import com.dvtrsc.valorprofs.ws.db.DBResources;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
/*
 * DBBaseController : contact point with DB. 
 */

public abstract class DBBaseController
{
	static final Logger logger = Logger.getLogger(DBBaseController.class);
  
	@SuppressWarnings("rawtypes")
	protected static <T extends BaseResponse, Q extends BaseParameters> T doCall(DBResources command, Q Q, Class<T> responseClass)
	{
	    CallableStatement cs = null;
	    Connection cn = null;
	    T R = null;
	    ResultSet rs = null;
	    
	    try
	    {
	    	// generates a response object
	    	R = (T)responseClass.newInstance();
		      
		    // picks up a valid connection from pool
		    cn = DBConnectionPool.getConnection();
		      
		    // prepare command indicated in DBController
		    cs = cn.prepareCall(command.toString());
		      
		    // map parameters from parameter object to callablestatement
		    Q.mapParameters(cs);
		      
		    // register, in response, the OUT parameters
		    R.registerOUTparameters(cs);
		      
		    // call to DB
		    rs = cs.executeQuery();
		     
		    // map OUT parameters result to response
		    R.mapResponseFromResult(cs);
		    
		    // In case of resultset, map it as list
		    if (ListResponse.class.isAssignableFrom(responseClass)) 
		        ((ListResponse)R).addItems(rs);     
	    }
	    catch (SQLException e) // unexpected errors
	    {
		    R.rc = -1;
		    logger.error(e);
		    logger.error("Response class " + responseClass.getCanonicalName());
	    }
	    catch (InstantiationException|IllegalAccessException e)
	    {
		    logger.error(e);
		    logger.error("Response class " + responseClass.getCanonicalName());
	    }
	    finally
	    {
	    	// 'close' connections (marking them to Hikari to reuse, not performance loose closing & opening real TCP/IP connections)
		    try
		    {
		    	if (cs != null) cs.close();		    
		        if (cn != null) cn.close();
		    }
		    catch (SQLException e) // in case of unexpected error, don't do nothing: DBCP will kill and flush invalid connections
		    {
		    	logger.warn(e);
		    }
	    }
	    
	    return R;    
	}
}