package com.example.demo.handlers;

import com.example.demo.entities.Conversion;
//import lombok.var;
import com.example.demo.models.ConversionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import com.example.demo.services.IConversionService;

import java.io.IOException;

@Component
public class ConversionHandler {

    @Autowired
    private IConversionService conversionService;

    public Mono<ServerResponse> getConversion(ServerRequest serverRequest){

        return ServerResponse.ok().body(conversionService.getConversions(),Conversion.class);
    }
    public Mono<ServerResponse> createConversion(ServerRequest serverRequest) {

        var conversionDTOMono = serverRequest.bodyToMono(ConversionDTO.class);

        return conversionDTOMono.flatMap(conversionDTO -> {
            try {
                return
                        ServerResponse.status(HttpStatus.CREATED)
                        .body(conversionService.createConversion(conversionDTO), Conversion.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}