package com.edupath.msuser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_profiles")
public class UserProfile {
    @Id
    private String userId;
    private String bio;
    private String interestArea;

    @Field("experience_level")
    private String experienceLevel;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getInterestArea() {
        return interestArea;
    }

    public void setInterestArea(String interestArea) {
        this.interestArea = interestArea;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public UserProfile() {
    }

    public UserProfile(String userId, String bio, String interestArea, String experienceLevel) {
        this.userId = userId;
        this.bio = bio;
        this.interestArea = interestArea;
        this.experienceLevel = experienceLevel;
    }
}
