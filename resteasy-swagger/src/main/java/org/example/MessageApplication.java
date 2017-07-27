package org.example;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		
		BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/resteasy-swagger/rest");
        beanConfig.setResourcePackage("org.example");
        beanConfig.setScan(true);
		
		singletons.add(new MessageRestService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	
	@Override
    public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet();
		resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        return resources;
	}
}
