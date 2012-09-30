package com.cv.tech.framework.configuration;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cv.tech.framework.service.AppUserDetailsService;
import com.cv.tech.framework.util.ApplicationInterceptor;
import com.mongodb.Mongo;

@Configuration
@PropertySource(value="classpath:application.properties")
public class AppConfiguration {

	@Autowired
	private Environment environment;
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver intRes = new InternalResourceViewResolver();
		intRes.setPrefix("/WEB-INF/views/");
		intRes.setSuffix(".jsp");
		intRes.setOrder(1);
		return intRes;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(10000000);
		return commonsMultipartResolver;
	}

	@Bean
	public ContentNegotiatingViewResolver cnViewResolver() {
		ContentNegotiatingViewResolver cnViewResolver = new ContentNegotiatingViewResolver();
		Map<String, String> mediaTypes = new HashMap<String, String>();
		mediaTypes.put("html", "text/html");
		mediaTypes.put("pdf", "application/pdf");
		mediaTypes.put("xml", "application/xml");
		mediaTypes.put("json", "application/json");

		cnViewResolver.setMediaTypes(mediaTypes);
		cnViewResolver.setOrder(0);

		return cnViewResolver;
	}

	@Bean
	public AppUserDetailsService appUserDetailsService() {
		AppUserDetailsService appUserDetailsService = new AppUserDetailsService();
		return appUserDetailsService;
	}

	public @Bean
	Mongo mongo() throws UnknownHostException {
		return new Mongo(environment.getProperty("dbhost"));
	}

	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new Mongo(), environment.getProperty("databaseName"));
	}

	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

	public @Bean
	ApplicationInterceptor applicationInterceptor() {
		return new ApplicationInterceptor();
	}
}
