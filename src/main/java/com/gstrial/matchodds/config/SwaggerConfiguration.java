package com.gstrial.matchodds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket matchOddsSwaggerConfig() {
        // Add desired swagger properties
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors
                .basePackage("com.gstrial.matchodds.controller"))           // target controller package ONLY
            .build().apiInfo(matchOddsDetails());
    }

    private ApiInfo matchOddsDetails() {
        return new ApiInfo("matchOdds-API", "", "1.0", "", null, "", "", Collections.emptyList());
    }


}
