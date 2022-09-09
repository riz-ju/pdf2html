package com.example.demo.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi conversionOpenAPI()
    {
        var paths = new String[]{"/conversion/"};
        return GroupedOpenApi.builder().group("conversion").pathsToMatch(paths).build();
    }
}
