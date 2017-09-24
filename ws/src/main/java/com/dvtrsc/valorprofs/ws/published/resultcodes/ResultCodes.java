package com.dvtrsc.valorprofs.ws.published.resultcodes;

import com.dvtrsc.valorprofs.ws.db.DBController;
import com.dvtrsc.valorprofs.ws.entities.BaseResource;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/*
 * ResultCodes. Return result codes available in DB (for cache)
 */
@Path("resultcodes")
public class ResultCodes extends BaseResource
{
	@GET
	@Produces({"application/json"})
	public Response getResultCodes(@Context UriInfo ui) throws IOException, InstantiationException, IllegalAccessException
	{
	    return WithAccessResponse(DBController.doGetResultCodes(new GetResultCodesParameters()));
	}
}
