/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showmeyourcheatsheet.auth.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Owner
 */
@Document(collection="USER")
public class MUser {
    @Id
    public String id;
    
    @Email(message="*Please provide a valid Email")
    @NotEmpty(message="*Please provide an Email")
    public String username;
    
    @Length(min = 6, message="*Your password must have at least 6 characters")
    @NotEmpty(message = "*Please provide your password")
    public String password;
    
    public MUser(){}
    
    public MUser(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
    
}
