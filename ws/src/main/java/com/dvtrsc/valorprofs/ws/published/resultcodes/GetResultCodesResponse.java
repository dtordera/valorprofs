package com.dvtrsc.valorprofs.ws.published.resultcodes;

import com.dvtrsc.valorprofs.ws.entities.ListResponse;
import com.dvtrsc.valorprofs.ws.entities.pojos.ResultCode;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetResultCodesResponse
  extends ListResponse<ResultCode>
{
	@Override
  public ResultCode itemFromResultSet(ResultSet rs)
    throws SQLException
  {
    ResultCode rc = new ResultCode();
    
    rc.id = rs.getInt(1);
    rc.description = rs.getString(2);
    
    return rc;
  }
}
