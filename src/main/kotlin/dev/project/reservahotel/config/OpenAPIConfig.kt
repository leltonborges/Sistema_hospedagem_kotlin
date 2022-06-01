package dev.project.reservahotel.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAPIConfig {

    @Bean
    fun shopOpenAPI(): OpenAPI{
        return OpenAPI()
            .info(Info().title("API sistema de reserva de hospedagem")
                .description("Api de estudo feita por Lelton Borges")
                .version("1.0.0")
                .license(License().name("Apache License").url("https://github.com/leltonborges/Sistema_hospedagem_kotlin")))
            .externalDocs(ExternalDocumentation()
                .description("Lelton Borges")
                .url("https://my-portfolio-lelton.herokuapp.com/"))
    }
}