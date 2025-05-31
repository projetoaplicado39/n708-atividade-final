package com.edupath.msroadmap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roadmaps")
public class Roadmap {

    @Id
    private String id;

    private String title;
    private String description;
    private InterestArea interestArea;
    private ExperienceLevel experienceLevel;

    public Roadmap() {
    }

    public Roadmap(String id, String title, String description, InterestArea interestArea, ExperienceLevel experienceLevel) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.interestArea = interestArea;
        this.experienceLevel = experienceLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InterestArea getInterestArea() {
        return interestArea;
    }

    public void setInterestArea(InterestArea interestArea) {
        this.interestArea = interestArea;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}

