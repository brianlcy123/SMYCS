package com.showmeyourcheatsheet.auth.model;

import javax.persistence.*;
import java.util.Set;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Role")
public class Role {
    private String id;
    private String name;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
