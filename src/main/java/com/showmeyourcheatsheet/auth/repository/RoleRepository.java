package com.showmeyourcheatsheet.auth.repository;

import com.showmeyourcheatsheet.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
