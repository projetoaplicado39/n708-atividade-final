package com.edupath.msauth.event.model;

import java.io.Serializable;

public class UserCreatedEvent implements Serializable {
    private String userId;
    private String username;

    public UserCreatedEvent() {
    }

    public UserCreatedEvent(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

