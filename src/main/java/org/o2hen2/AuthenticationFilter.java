package org.o2hen2;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	UriInfo uriInfo;

	public void filter(ContainerRequestContext arg0) throws IOException {
		System.err.println(uriInfo.getPathParameters().get("param").get(0));

	}

}
