package com.pratik.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.pratik.messenger.datamodel.ErrorMessage;


@Provider			// registers class with jax-rs
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataException>{

	@Override
	public Response toResponse(DataException ex) {
		// TODO Auto-generated method stub
		ErrorMessage erMsg = new ErrorMessage("404", ex.getMessage(), "www.google.com" );
		return Response.status(Status.NOT_FOUND)
				.entity(erMsg)
				.build();
	}

}
