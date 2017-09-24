package com.dvtrsc.valorprofs.ws.db;

/*
 * DBResources : procedure names to be called by DBBaseController. 
 */

public enum DBResources
{
	_VALIDATEACCESS_CALL("call validateaccess(?,?,?,?,?,?);"),  
	_GETRESULTCODES_CALL("call getresultcodes(?);"),  
	_CREATEPRODUCT_CALL("call createproduct(?,?,?,?,?,?);"),  
	_UPDATEPRODUCT_CALL("call updateproduct(?,?,?,?,?,?,?);"),  
	_GETPRODUCTINFO_CALL("call getproduct(?,?,?);"),  
	_DELETEPRODUCT_CALL("call deleteproduct(?,?,?);"),  
	_GETPERMISSIONS_CALL("call getallowedpermissions(?,?);");
	  
	private final String text;
	  
	private DBResources(String text)
	{
	    this.text = text;
	}
	  
	public String toString()
	{
	    return this.text;
	}
}