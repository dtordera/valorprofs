package com.dvtrsc.valorprofs.ws.published.products;

import com.dvtrsc.valorprofs.ws.entities.ListResponse;
import com.dvtrsc.valorprofs.ws.entities.pojos.Product;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * GetProductInfoRespons. Gets product list  
 */

public class GetProductInfoResponse extends ListResponse<Product>
{
	@Override
	public Product itemFromResultSet(ResultSet rs) throws SQLException
	{
		Product P = new Product();
    
		P.id = rs.getInt(1);
		P.name = rs.getString(2);
		P.available = Boolean.valueOf(rs.getBoolean(3));
		P.price = Float.valueOf(rs.getFloat(4));
		P.description = rs.getString(5);
		P.datecreated = rs.getTimestamp(6);
		P.lastupdated = rs.getTimestamp(7);
    
		return P;
	}
}
