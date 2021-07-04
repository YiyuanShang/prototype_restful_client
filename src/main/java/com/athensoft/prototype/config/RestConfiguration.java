package com.athensoft.prototype.config;

import org.springframework.hateoas.config.HypermediaRestTemplateConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
	
	@Bean
	RestTemplate hypermediaRestTemplate(HypermediaRestTemplateConfigurer configurer) { 
		return configurer.registerHypermediaTypes(new RestTemplate()); 
	}
	
//	@Bean 
//	RestTemplateCustomizer hypermediaRestTemplateCustomizer(HypermediaRestTemplateConfigurer configurer) { 
//	    return restTemplate -> { 
//	        configurer.registerHypermediaTypes(restTemplate); 
//	    };
//	}
}
