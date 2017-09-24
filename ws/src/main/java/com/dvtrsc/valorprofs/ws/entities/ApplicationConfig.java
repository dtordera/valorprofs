package com.dvtrsc.valorprofs.ws.entities;

import com.dvtrsc.valorprofs.ws.db.DBConnectionPool;


import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.apache.log4j.Logger;

/*
 * ApplicationConfig: main application entry point. Any initialization will be done here.  
 */

@ApplicationPath("res")
public class ApplicationConfig extends Application
{
static final Logger logger = Logger.getLogger(ApplicationConfig.class);
  
	@PostConstruct
	public void InitializeApp()
	{
	    logger.info("VALORPROFS Technical Test: Basic Login/CRUD API.");
	    logger.debug("InitializeApp() called.");
	    InitHikari();
	    logger.info("All ok.Listening!");
	}
	  
	private void InitHikari() 
	{ 
		DBConnectionPool.InitHikari();
	}
}
