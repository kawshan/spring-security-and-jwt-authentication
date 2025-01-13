package com.aukdevelopment.ytjwttutorial.repository;

import com.aukdevelopment.ytjwttutorial.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    Optional<UserEntity> findByUsername(String username);
}
