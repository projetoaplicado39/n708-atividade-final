package com.edupath.msuser.event.model;

import java.io.Serializable;

public class UserCreatedEvent implements Serializable {
    private String userId;
    private String username;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserCreatedEvent() {

    }

    public UserCreatedEvent(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}

