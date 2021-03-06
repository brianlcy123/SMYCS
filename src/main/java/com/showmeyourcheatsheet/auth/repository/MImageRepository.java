/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showmeyourcheatsheet.auth.repository;

import com.showmeyourcheatsheet.auth.model.Image;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Owner
 */
@RepositoryRestResource
public interface MImageRepository extends MongoRepository<Image, String>{
    List<Image> findFirst5ByOrderByCreateTimeStampDesc();
}
