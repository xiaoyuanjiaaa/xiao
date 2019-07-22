package com.fc.protocol.client.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertiesFileConfig {

	private Logger log = LoggerFactory.getLogger(PropertiesFileConfig.class);

	@Bean
	public PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
		ClassPathResource zookeeper = new ClassPathResource("zookeeper.properties");
		PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocations(new ClassPathResource[] { zookeeper });
		log.info("init config completed ");
		return propertyPlaceholderConfigurer;
	}

}
