package org.o2hen2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("rest/{param}")
public class Service {
	
	@MyAnnotation
	String string;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public A get(@PathParam("param") String param){
		System.err.println("get");


		
		return new A(param + string);
	}
}
