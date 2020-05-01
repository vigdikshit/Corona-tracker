package com.app.corona.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.corona.domain.DatabaseSequence;

@Repository
public interface SequenceGeneratorRepository extends MongoRepository<DatabaseSequence, String>{


}
