package com.sparta.interview_king;

import org.apache.catalina.User;

public class UserDetailsImpl  {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}