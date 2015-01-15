package org.o2hen2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Program {

	public static void main(String[] args) throws Exception {
/*
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998)
				.build();
		ResourceConfig config = new ResourceConfig(Service.class,
				AuthenticationFilter.class, MyFeature.class,
				JacksonFeature.class);
		Server server = JettyHttpContainerFactory.createServer(baseUri, config);

		server.start();
		server.join();
*/
		
        Server server = new Server(9998);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        server.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        /*This parameter tells the Jersey Servlet which of your REST resources to load. In this example we're adding the TestResource class. Jersey will then invoke this class for requests coming into paths denoted by the @Path parameter within the TestResource class. If you have multiple classes, you can either list them all comma separated, of use "jersey.config.server.provider.packages" and list the package name instead */
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages",  "org.o2hen2.Logbook");
        server.start();
        server.join();
	}

}
