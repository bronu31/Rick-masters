package com.microservice.rickmaster.swaggerconfig;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "swagger data",
                description = "swagger data for rick masters", version = "1.0.0",
                contact = @Contact(
                        name = "Толкачев Глеб",
                        email = "glebtolkacev08@gmail.com"
                )
        )
)
public class SwaggerInfo {

}
