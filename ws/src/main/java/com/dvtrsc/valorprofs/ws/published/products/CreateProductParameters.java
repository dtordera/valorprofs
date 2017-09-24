package com.dvtrsc.valorprofs.ws.published.products;

import com.dvtrsc.valorprofs.ws.entities.ProfiledParameters;
import java.sql.CallableStatement;
import java.sql.SQLException;

/*
 * CreateProductParameters. Product field details & mapping to procedure
 */
public class CreateProductParameters extends ProfiledParameters
{
	public String name;
	public Boolean available;
	public Float price;
	public String description;
  
	public CallableStatement mapParameters(CallableStatement cs) throws SQLException
	{
		super.mapParameters(cs);
		cs.setString(2, this.name);
		cs.setBoolean(3, this.available.booleanValue());
		cs.setFloat(4, this.price.floatValue());
		cs.setString(5, this.description);
    
		return cs;
	}
}
