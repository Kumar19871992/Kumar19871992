package com.ssnc.ba2cust.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	
	public Response toResponse(Throwable ex)
	{
		if(ex instanceof DataSourceNotAvailable)
		{
		
			return Response.status(Status.INTERNAL_SERVER_ERROR)
				       .entity(new ErrorProps("500", ex.getMessage()))
				       .build();
		}
		else
		{
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorProps("500", ex.getMessage()))
					.build();
		}
	}

}