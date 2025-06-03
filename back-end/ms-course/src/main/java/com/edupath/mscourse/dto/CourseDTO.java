package com.edupath.mscourse.dto;

import java.util.List;

public class CourseDTO {
    private String id;
    private String title;
    private String description;
    private String url;
    private String provider;
    private String duration;
    private String difficultyLevel;
    private List<String> stepIds;

    public CourseDTO() {
    }

    public CourseDTO(String id, String title, String description, String url, String provider, String duration, String difficultyLevel, List<String> stepIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.provider = provider;
        this.duration = duration;
        this.difficultyLevel = difficultyLevel;
        this.stepIds = stepIds;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<String> getStepIds() {
        return stepIds;
    }

    public void setStepIds(List<String> stepIds) {
        this.stepIds = stepIds;
    }
}
