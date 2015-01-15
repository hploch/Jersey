package org.o2hen2;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;

@Singleton
public class MyInjectionResolver implements InjectionResolver<MyAnnotation> {
	
	@Context
	private UriInfo uriInfo;
	
	@Context
	private HttpServletRequest request;
	
	public boolean isConstructorParameterIndicator() {
		return true;
	}

	public boolean isMethodParameterIndicator() {
		return true;
	}

	public Object resolve(Injectee injectee, ServiceHandle<?> arg1) {


		if (String.class.equals(injectee.getRequiredType())) {
			return request.getRequestURI();
		}
		
		return null;
	}

}
