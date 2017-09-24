package com.dvtrsc.valorprofs.ws.published.products;

import com.dvtrsc.valorprofs.ws.db.DBController;
import com.dvtrsc.valorprofs.ws.entities.BaseResource;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

/*
 * Products. Resource for CRUD to Products. Implementation of HTTP verbs POST (new), PUT (update), DELETE (=) & GET (read)
 * OOP : due BaseResource gets all the duty, code in this class is just get a parameter object representation of request 
 * params, and call db. So, implement new resources are quite easy, just defining parameter & response class    
 */

@Path("products")
public class Products extends BaseResource
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts(@Context UriInfo ui) throws IOException, InstantiationException, IllegalAccessException
	{
		GetProductInfoParameters Q = assignParams(ui.getPathParameters(), GetProductInfoParameters.class);
		return answerToRequest(Q, (e)->{ return DBController.doGetProductInfo(Q); });
	}
  
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newProduct(String payload) throws JsonGenerationException, JsonMappingException, IOException
	{
		  CreateProductParameters Q = assignParams(payload,CreateProductParameters.class);
		  return answerToRequest(Q, (e) -> {return DBController.doCreateProduct(Q); });
	}
  
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(String payload) throws JsonGenerationException, JsonMappingException, IOException
	{
		UpdateProductParameters Q = assignParams(payload,UpdateProductParameters.class);
		return answerToRequest(Q, (e) -> {return DBController.doUpdateProduct(Q); });
	}
  
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProducts(@Context UriInfo ui) throws IOException, InstantiationException, IllegalAccessException
	{
		DeleteProductParameters Q = assignParams(ui.getPathParameters(), DeleteProductParameters.class);
		return answerToRequest(Q, (e)->{ return DBController.doDeleteProduct(Q); });
	}
}
