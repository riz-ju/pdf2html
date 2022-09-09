package com.example.demo.services;

import com.example.demo.entities.Conversion;
import com.example.demo.models.ConversionDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public interface IConversionService {
Flux<Conversion> getConversions();
Mono<Conversion> createConversion(ConversionDTO conversionDTO) throws IOException;

}
