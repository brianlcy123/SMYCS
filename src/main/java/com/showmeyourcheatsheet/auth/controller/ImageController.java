/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showmeyourcheatsheet.auth.controller;

import com.showmeyourcheatsheet.auth.model.Image;
import com.showmeyourcheatsheet.auth.model.Tag;
import com.showmeyourcheatsheet.auth.repository.MImageRepository;
import com.showmeyourcheatsheet.auth.repository.MTagRepository;
import com.showmeyourcheatsheet.auth.service.NextIdService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Owner
 */
@Controller
@RequestMapping("/img")
public class ImageController {
    @Autowired
    MImageRepository imageRepository;
    @Autowired
    MTagRepository tagRepository;
    @Autowired
    NextIdService nextIdService;
    
    @RequestMapping( method=RequestMethod.GET)
    public String getSubView( Model model ) {
        System.out.println("getSubView");
             
        try{
            ModelAndView mv = new ModelAndView( "resources/templates/upload-body" );
        }catch(Throwable t){
            System.out.println(t.getMessage());
        }        
        return "resources/templates/upload-body";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Image> logFileUpload(@RequestBody Image image){
        System.out.println("Processing logFileUpload");
        System.out.println(image);
        String[] tags = image.getTagString().split(",");
        List<Tag> tagList = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username  
        
        for(String tagName : tags){
            Tag tag = tagRepository.findByTagName(tagName);
            if(tag == null){
                tag = new Tag();
                int nextTagId = nextIdService.getNextUserId("TAG");
                System.out.println("Create new tag Id :"+nextTagId);
                tag.setId(String.valueOf(nextTagId));
                tag.setTagName(tagName);
                tag.setCreatorName(name);
                tag = tagRepository.insert(tag);
                
            }
            tagList.add(tag);
        }
        image.setTags(tagList);
        image.setCreatorName(name);
        Date newDate = new Date();
        image.setCreateTimeStamp(newDate);
        image.setLastUpdatedTimeStamp(newDate);
        imageRepository.insert(image);
           
        return new ResponseEntity<>(image, HttpStatus.CREATED);
    }
    
    @RequestMapping(path="/all", method = RequestMethod.GET)
    public ResponseEntity<List<Image>> findAllImages(){
        List<Image> images = imageRepository.findAll();
        return new ResponseEntity<>(images,HttpStatus.OK);
    }
    
    @RequestMapping(path="/last5",method = RequestMethod.GET)
    public ResponseEntity<List<Image>> findLast5(){
        List<Image> images = imageRepository.findFirst5ByOrderByCreateTimeStampDesc();
        return new ResponseEntity<>(images,HttpStatus.OK);
    }
    
}
