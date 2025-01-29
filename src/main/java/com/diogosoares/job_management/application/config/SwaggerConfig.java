package com.diogosoares.job_management.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Job Management API")
                .description("API responsible to management jobs")
                .version("1"))
            .addSecurityItem(new SecurityRequirement().addList("jwt_auth"))
            .components(new Components()
                .addSecuritySchemes("jwt_auth", 
                    new SecurityScheme()
                        .name("jwt_auth")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                ));
    }
}