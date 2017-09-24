package com.dvtrsc.valorprofs.ws.published.permissions;
 
import com.dvtrsc.valorprofs.ws.entities.ListResponse;
import com.dvtrsc.valorprofs.ws.entities.pojos.Permission;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * GetPermisisonResponse. List of permissions allowed to a profile id
 */
public class GetPermissionsResponse extends ListResponse<Permission>
{
	@Override
	public Permission itemFromResultSet(ResultSet rs) throws SQLException
	{
		Permission P = new Permission();
     
		P.id = rs.getInt(1);
		P.description = rs.getString(2);
     
		return P;
	}
}
