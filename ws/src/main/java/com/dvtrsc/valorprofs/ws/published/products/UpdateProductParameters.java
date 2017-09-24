package com.dvtrsc.valorprofs.ws.published.products;

import java.sql.CallableStatement;
import java.sql.SQLException;

/*
 * UpdateProductsParameters. Related info to update products.  
 */

public class UpdateProductParameters extends CreateProductParameters
{
	public int id;
	  
	public CallableStatement mapParameters(CallableStatement cs) throws SQLException
	{
		super.mapParameters(cs);
	    cs.setString(2, this.name);
	    cs.setBoolean(3, this.available.booleanValue());
	    cs.setFloat(4, this.price.floatValue());
	    cs.setString(5, this.description);
	    cs.setInt(6, this.id);
	    
	    return cs;
	}
}
