package com.dvtrsc.valorprofs.ws.published.permissions;

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
 * Permissions. Gets permission list for a user
 */
@Path("permissions")
public class Permissions extends BaseResource
{
	@GET
	@Produces({"application/json"})
	public Response getPermissions(@Context UriInfo ui) throws IOException, InstantiationException, IllegalAccessException
	{
		GetPermissionsParameters Q = assignParams(ui.getPathParameters(), GetPermissionsParameters.class);
		return answerToRequest(Q, (e)->{ return DBController.doGetPermissions(Q); });
	}
}