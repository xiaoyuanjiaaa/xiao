package com.fc.protocol.client.demo.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fc.log.client.interceptor.LoggingTagInterceptor;

@Configuration
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {

	private Logger log = LoggerFactory.getLogger(WebAppConfig.class);

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("配置日志拦截器");
		LoggingTagInterceptor logInterceptor = new com.fc.log.client.interceptor.LoggingTagInterceptor();
		String[] logMapping = new String[] { "/**" };
		String[] logMappingExclude = new String[] { "/api-docs/**", "/swagger/**", "/static/**", "/view/**",
				"/WEB-INF/view/**" };
		registry.addInterceptor(logInterceptor).addPathPatterns(logMapping).excludePathPatterns(logMappingExclude);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new org.springframework.http.converter.StringHttpMessageConverter(Charset.forName("UTF-8")));
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		jsonConverter.setSupportedMediaTypes(supportedMediaTypes);
		converters.add(jsonConverter);
	}

}
