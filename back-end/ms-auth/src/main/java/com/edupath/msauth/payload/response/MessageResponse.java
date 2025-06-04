package com.edupath.msauth.payload.response;

public class MessageResponse {
    private String message;
    private String userId;
    private String username;

    public MessageResponse(String message, String userId, String username) {
        this.message = message;
        this.userId = userId;
        this.username = username;
    }

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
}
