package com.dvtrsc.valorprofs.ws.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/*
 * DBConnectionPool. DB connection pool using Hikari DBCP
 */

public final class DBConnectionPool
{
	static final Logger logger = Logger.getLogger(DBConnectionPool.class);
	private static HikariDataSource ds;
	private static DBConnectionPool _instance = null;
  
	// there is need of at least one created instance in memory, so there are connections ready before
	// first call to DBConnectionPool.
	private static void EnsureInstanceExistence()
	{
		if (_instance == null) 
		_instance = new DBConnectionPool();
	}
  
	private DBConnectionPool()
	{
		logger.info("Setting up Hikari DBCP connection pool.");
		    
		ds = new HikariDataSource(new HikariConfig(getClass().getClassLoader().getResource("hikari.properties").getPath()));    
		ds.setMaximumPoolSize(20);
	}
	
	// Hikari delivers a connection from pool as needed
	public static Connection getConnection() throws SQLException
	{
		EnsureInstanceExistence();
	    return ds.getConnection();
	}

	// call for a connection to make Hikari begin to work
	public static void InitHikari()
	{
		Connection cn = null;
	    try
	    {
	    	cn = getConnection(); return;
	    }
	    catch (SQLException e)
	    {
	    	logger.error(e);
	    }
	    finally
	    {
	    	try
	    	{
	    		// finally 'close' connection. In fact, connection it's marked for reuse. All is managed internally.
	    		if (cn != null) 
	    			cn.close();
	    	}
	    	catch (SQLException i)
	    	{
	    		logger.warn(i);
	    	}
	    }
	}
}
