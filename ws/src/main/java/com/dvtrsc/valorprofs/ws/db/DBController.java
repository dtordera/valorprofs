package com.dvtrsc.valorprofs.ws.db;

import com.dvtrsc.valorprofs.ws.entities.DBBaseController;

import com.dvtrsc.valorprofs.ws.entities.ValidateAccessParameters;
import com.dvtrsc.valorprofs.ws.entities.ValidateAccessResponse;
import com.dvtrsc.valorprofs.ws.published.permissions.GetPermissionsParameters;
import com.dvtrsc.valorprofs.ws.published.permissions.GetPermissionsResponse;
import com.dvtrsc.valorprofs.ws.published.products.CreateProductParameters;
import com.dvtrsc.valorprofs.ws.published.products.CreateProductResponse;
import com.dvtrsc.valorprofs.ws.published.products.DeleteProductParameters;
import com.dvtrsc.valorprofs.ws.published.products.DeleteProductResponse;
import com.dvtrsc.valorprofs.ws.published.products.GetProductInfoParameters;
import com.dvtrsc.valorprofs.ws.published.products.GetProductInfoResponse;
import com.dvtrsc.valorprofs.ws.published.products.UpdateProductParameters;
import com.dvtrsc.valorprofs.ws.published.products.UpdateProductResponse;
import com.dvtrsc.valorprofs.ws.published.resultcodes.GetResultCodesParameters;
import com.dvtrsc.valorprofs.ws.published.resultcodes.GetResultCodesResponse;

/*
 * DBController. Wrapper for doCall method on DBBaseController
 */

public class DBController extends DBBaseController
{
	public static GetResultCodesResponse doGetResultCodes(GetResultCodesParameters Q)
	{
	    return (GetResultCodesResponse)doCall(DBResources._GETRESULTCODES_CALL, Q, GetResultCodesResponse.class);
	}
	  
	public static CreateProductResponse doCreateProduct(CreateProductParameters Q)
	{
	    return (CreateProductResponse)doCall(DBResources._CREATEPRODUCT_CALL, Q, CreateProductResponse.class);
	}
	  
	public static UpdateProductResponse doUpdateProduct(UpdateProductParameters Q)
	{
	    return (UpdateProductResponse)doCall(DBResources._UPDATEPRODUCT_CALL, Q, UpdateProductResponse.class);
	}
	  
	public static ValidateAccessResponse doValidateAccess(ValidateAccessParameters Q)
	{
	    return (ValidateAccessResponse)doCall(DBResources._VALIDATEACCESS_CALL, Q, ValidateAccessResponse.class);
	}
	  
	public static GetProductInfoResponse doGetProductInfo(GetProductInfoParameters Q)
	{
	    return (GetProductInfoResponse)doCall(DBResources._GETPRODUCTINFO_CALL, Q, GetProductInfoResponse.class);
	}
	  
	public static DeleteProductResponse doDeleteProduct(DeleteProductParameters Q)
	{
	    return (DeleteProductResponse)doCall(DBResources._DELETEPRODUCT_CALL, Q, DeleteProductResponse.class);
	}
	  
	public static GetPermissionsResponse doGetPermissions(GetPermissionsParameters Q)
	{
	    return (GetPermissionsResponse)doCall(DBResources._GETPERMISSIONS_CALL, Q, GetPermissionsResponse.class);
	}
}
