package com.dvtrsc.valorprofs.ws.published.resultcodes;

import com.dvtrsc.valorprofs.ws.entities.BaseParameters;
import java.sql.CallableStatement;
import java.sql.SQLException;

/*
 * GetResultCodesParameters. As resultcodes does not need validation, we derive it directly from BaseParameters
 */

public class GetResultCodesParameters extends BaseParameters
{
	public CallableStatement mapParameters(CallableStatement cs) throws SQLException
	{
		return cs;
	}
}
