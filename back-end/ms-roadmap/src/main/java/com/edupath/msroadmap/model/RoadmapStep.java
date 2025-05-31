package com.edupath.msroadmap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roadmap_steps")
public class RoadmapStep {

    @Id
    private String id;

    private String roadmapId;
    private String title;
    private String description;
    private Integer orderIndex;

    public RoadmapStep() {
    }

    public RoadmapStep(String id, String roadmapId, String title, String description, Integer orderIndex) {
        this.id = id;
        this.roadmapId = roadmapId;
        this.title = title;
        this.description = description;
        this.orderIndex = orderIndex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoadmapId() {
        return roadmapId;
    }

    public void setRoadmapId(String roadmapId) {
        this.roadmapId = roadmapId;
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

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}
