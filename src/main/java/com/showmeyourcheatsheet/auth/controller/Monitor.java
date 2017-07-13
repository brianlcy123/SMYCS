/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showmeyourcheatsheet.auth.controller;

import com.showmeyourcheatsheet.auth.model.Image;
import com.showmeyourcheatsheet.auth.model.Role;
import com.showmeyourcheatsheet.auth.model.User;
import com.showmeyourcheatsheet.auth.repository.MImageRepository;
import com.showmeyourcheatsheet.auth.repository.MTagRepository;
import com.showmeyourcheatsheet.auth.repository.RoleRepository;
import com.showmeyourcheatsheet.auth.repository.UserRepository;
import com.showmeyourcheatsheet.auth.service.NextIdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Owner
 */
@RestController
@RequestMapping("/monitor")
public class Monitor {
    @Autowired
    MImageRepository imageRepository;
    @Autowired
    MTagRepository tagRepository;
    @Autowired
    NextIdService nextIdService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    
   @RequestMapping(value = "/images", method = RequestMethod.GET)
    public ResponseEntity<List<Image>> getAllImage(){
        List<Image> images = imageRepository.findAll();
        return new ResponseEntity<>(images,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleRepository.findAll();
        return new ResponseEntity<>(roles,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
