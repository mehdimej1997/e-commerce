package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		// CREATE OBJECT
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		
		// DISABLE METHODS PRODUCT PUT, POST & DELETE
		
		config.getExposureConfiguration()
		.forDomainType(Product.class)
		.withItemExposure((metadatan, httpMethods) -> httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		// DISABLE METHODS PRODECTCATEGORY PUT, POST & DELETE
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadatan, httpMethods) -> httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	
	}
}
