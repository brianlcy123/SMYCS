package com.showmeyourcheatsheet.auth.repository;

import com.showmeyourcheatsheet.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
