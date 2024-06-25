package com.br.fatecrl.TodoList.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI getOpenAPIConfig() {
        OpenAPI openApi = new OpenAPI();
        Contact contact = new Contact()
                .name("Projeto TodoList")
                .email("pedro.goncalves22@fatec.sp.gov.br");

        License license = new License()
                .name("Apache 2.0")
                .url("http://springdoc.org");
        Info info = new Info()
                .title("TodoList API")
                .description("API para gerenciamento de tarefas")
                .version("v1.0.0")
                .contact(contact)
                .license(license);
        return openApi.info(info);
    }
}