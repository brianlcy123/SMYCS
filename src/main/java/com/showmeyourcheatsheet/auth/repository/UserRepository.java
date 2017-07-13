package com.showmeyourcheatsheet.auth.repository;

import com.showmeyourcheatsheet.auth.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
