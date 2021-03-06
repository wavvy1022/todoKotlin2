package com.example.todo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.w3c.dom.DocumentType
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import javax.tools.DocumentationTool

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun docket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
    }
}