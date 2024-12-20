package com.example.questService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MoodiQuest API")
                        .version("1.0")
                        .description("API для MoodiQuest микросервиса"))
                .addServersItem(new Server().url("https://moodiquest.online"));
    }
}
