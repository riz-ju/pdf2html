package com.example.demo.repositories;

import com.example.demo.entities.Conversion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConversionRepository extends ReactiveMongoRepository<Conversion,String> {


}
