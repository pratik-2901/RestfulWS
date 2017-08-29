package com.pratik.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.pratik.messenger.datamodel.ErrorMessage;

@Provider
public class GenericExcpetionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		// TODO Auto-generated method stub
		ErrorMessage erMsg = new ErrorMessage("500", ex.getMessage(), "www.google.com" );
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(erMsg)
				.build();
	}
	
}
