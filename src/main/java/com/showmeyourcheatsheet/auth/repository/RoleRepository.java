package com.showmeyourcheatsheet.auth.repository;

import com.showmeyourcheatsheet.auth.model.Role;
import com.showmeyourcheatsheet.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String>{
}
