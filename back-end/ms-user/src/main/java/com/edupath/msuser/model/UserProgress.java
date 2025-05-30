package com.edupath.msuser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "user_progress")
public class UserProgress {
    @Id
    private String id;
    private String userId;
    private String roadmapId;
    private String stepId;
    private boolean completed;
    private LocalDateTime completionDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoadmapId() {
        return roadmapId;
    }

    public void setRoadmapId(String roadmapId) {
        this.roadmapId = roadmapId;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public UserProgress() {
    }

    public UserProgress(String id, String userId, String roadmapId, String stepId, boolean completed, LocalDateTime completionDate) {
        this.id = id;
        this.userId = userId;
        this.roadmapId = roadmapId;
        this.stepId = stepId;
        this.completed = completed;
        this.completionDate = completionDate;
    }
}
