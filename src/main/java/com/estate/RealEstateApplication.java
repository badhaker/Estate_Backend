package com.estate;

import java.util.Properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

import com.estate.resource.AppConstant;

@SpringBootApplication
@EnableAsync
public class RealEstateApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RealEstateApplication.class).sources(RealEstateApplication.class)
				.properties(getProperties()).run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		return springApplicationBuilder.sources(RealEstateApplication.class).properties(getProperties());
	}

	
	static Properties getProperties() {
		Properties props = new Properties();
		props.put("spring.config.location", AppConstant.FileLocation.PROPERTY_PATH);
		return props;
	}
}
