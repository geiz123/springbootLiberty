package com.hd.hddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Deploying to a JEE server.
 *
 * https://spring.io/blog/2014/03/07/deploying-spring-boot-applications#what-about-the-java-ee-application-server
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.hd")
public class HdDemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HdDemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HdDemoApplication.class);
	}
	
	private static Class<HdDemoApplication> applicationClass = HdDemoApplication.class;
}
