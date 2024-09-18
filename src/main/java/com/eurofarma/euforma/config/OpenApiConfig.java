package com.eurofarma.euforma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
				.title("Eurofarma Trainings")
				.version("v1")
				.description("This API offers a service for the Eurofarma Company to facilitate the management of its training")
				.termsOfService("")
				.license(new License().name("Apache 2.0").url("")));
	}
}
