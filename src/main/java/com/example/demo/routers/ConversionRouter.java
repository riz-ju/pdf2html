package com.example.demo.routers;

import com.example.demo.handlers.ConversionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.example.demo.services.ConversionService;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
//import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

@Configuration
@EnableWebFlux
public class ConversionRouter implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> conversionAPI(ConversionHandler conversionHandler) {
        return route()
               .POST("/conversion/", conversionHandler::createConversion, ops -> ops.beanClass(ConversionService.class).beanMethod("createConversion"))
                .GET("/conversion/",conversionHandler::getConversion, ops -> ops.beanClass(ConversionService.class).beanMethod("getConversions"))
                .build();

    }
}