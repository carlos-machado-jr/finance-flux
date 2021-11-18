package com.api.financeflux.infra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.financeflux.infra.entity.UserEntity;
@Repository
public interface UserRepositoryJpa extends MongoRepository<UserEntity, String>{

}
