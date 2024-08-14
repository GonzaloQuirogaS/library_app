package com.gonzaloquiroga.app.libreria.libreriaapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.springframework.context.annotation.Configuration;

//Clase de configuracion de Swagger
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Library",
                version = "1.0.0",
                description = "Library application"

        ),
        security = @SecurityRequirement(
                name = "Bearer Authentication"
        ))
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer")
public class OpenApiConfig {
}
