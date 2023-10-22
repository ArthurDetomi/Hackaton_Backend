package com.projeto.hackaton.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Hackaton")
                        .version("1.0.0")
                        .description("Projeto de turismo")
                        .termsOfService("")
                        .license(new License()
                                .name("")
                                .url("")
                        )
                );
    }


}
