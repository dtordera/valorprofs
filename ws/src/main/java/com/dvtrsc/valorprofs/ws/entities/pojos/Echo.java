package com.dvtrsc.valorprofs.ws.entities.pojos;

import java.sql.Timestamp;
import java.time.Instant;

/*
 * Ping/Echo 
 */
public class Echo
{
	public String echo;
	public Timestamp timestamp;
  
	public Echo(String toecho)
	{
		this.echo = ((toecho == null) || (toecho == "") ? "pong" : toecho);
		this.timestamp = Timestamp.from(Instant.now());
	}
}
