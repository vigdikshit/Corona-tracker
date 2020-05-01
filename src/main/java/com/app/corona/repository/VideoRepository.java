package com.app.corona.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.corona.domain.Video;

@Repository
public interface VideoRepository extends MongoRepository<Video, Long>{

	
}
