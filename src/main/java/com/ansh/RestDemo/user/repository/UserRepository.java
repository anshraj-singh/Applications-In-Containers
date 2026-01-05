package com.ansh.RestDemo.user.repository;

import com.ansh.RestDemo.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

}
