package com.dvtrsc.valorprofs.ws.published.ping;

import com.dvtrsc.valorprofs.ws.entities.BaseResponse;
import com.dvtrsc.valorprofs.ws.entities.pojos.Echo;
/*
 * PingResponse. Returns an echo + timestamp
 */
public class PingResponse extends BaseResponse
{
	public Echo echo;  
	public PingResponse(String s)
	{
		this.echo = new Echo(s);
	}
}
