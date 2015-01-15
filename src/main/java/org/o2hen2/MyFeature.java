package org.o2hen2;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class MyFeature implements Feature {

	public boolean configure(FeatureContext context) {
		context.register(new MyBinder());
		return true	;
	}

}
