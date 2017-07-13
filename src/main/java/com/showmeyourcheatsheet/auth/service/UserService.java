package com.showmeyourcheatsheet.auth.service;

import com.showmeyourcheatsheet.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
