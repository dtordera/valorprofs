package com.dvtrsc.valorprofs.ws.published.products;

import com.dvtrsc.valorprofs.ws.entities.ProfiledParameters;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.ws.rs.core.MultivaluedMap;
/*
 * DeleteProductParameters. Mapping to DB & assign method to map from queryparameters
 */
public class DeleteProductParameters extends ProfiledParameters
{
	public int id;
  
	public CallableStatement mapParameters(CallableStatement cs) throws SQLException
	{
		super.mapParameters(cs);
		cs.setInt(2, this.id);
    
		return cs;
	}
  
	public void assign(MultivaluedMap<String, String> ss)
	{
		super.assign(ss);
		this.id = Integer.parseUnsignedInt((String)ss.getFirst("id"));
	}
}
