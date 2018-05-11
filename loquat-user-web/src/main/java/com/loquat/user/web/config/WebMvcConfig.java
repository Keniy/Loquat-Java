package com.loquat.user.web.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.loquat.user.web.util.DateConverter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new DateConverter());
	}
	
	@Bean
	public ExecutorService executorService() {
		return Executors.newCachedThreadPool();
	}
}
