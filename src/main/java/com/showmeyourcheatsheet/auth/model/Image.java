/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showmeyourcheatsheet.auth.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Owner
 */
@Document(collection="IMAGE")
public class Image {
    @Id
    public String id;
    public Date createTimeStamp;
    public Date lastUpdatedTimeStamp;
    public List<Tag> tags;
    public String creatorName;
    public String imgurId;
    public List<String> likes;
    public String tagString;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Date createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public Date getLastUpdatedTimeStamp() {
        return lastUpdatedTimeStamp;
    }

    public void setLastUpdatedTimeStamp(Date lastUpdatedTimeStamp) {
        this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getImgurId() {
        return imgurId;
    }

    public void setImgurId(String imgurId) {
        this.imgurId = imgurId;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public String getTagString() {
        return tagString;
    }

    public void setTagString(String tagString) {
        this.tagString = tagString;
    }
    

    @Override
    public String toString() {
        return "Image{" + "id=" + id + ", createTimeStamp=" + createTimeStamp + ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp + ", tags=" + tags + ", creatorId=" + creatorName + ", imgurId=" + imgurId + ", likes=" + likes + ", tagString=" + tagString +'}';
    }
    
}
