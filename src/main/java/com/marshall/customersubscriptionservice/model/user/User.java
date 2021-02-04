package com.marshall.customersubscriptionservice.model.user;

public class User {
    private Long userId;

    public User(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}