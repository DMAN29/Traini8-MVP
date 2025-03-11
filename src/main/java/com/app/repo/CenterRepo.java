package com.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Center;

@Repository
public interface CenterRepo extends MongoRepository<Center, String> {

}
