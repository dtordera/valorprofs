package com.dvtrsc.valorprofs.ws.entities;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/*
 * CORSSupport : general JAX-RS filter to add CORS support at responses. 
 * In this case, API will be behind an nginx proxy server who add this headers more effectively & configurable,so
 * I dehabilitate it here
 */

@Provider
public class CORSSupport implements ContainerResponseFilter
{
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)throws IOException
	{
/*		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type, Accept-Type");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		responseContext.getHeaders().add("Allow", "OPTIONS");*/
	}
}