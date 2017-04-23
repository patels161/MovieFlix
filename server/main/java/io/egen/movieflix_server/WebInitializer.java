package io.egen.movieflix_server;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import io.egen.movieflix_server.JPAConfig;
import io.egen.movieflix_server.WebConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] { WebConfig.class, JPAConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/api/*"};
	}

}
