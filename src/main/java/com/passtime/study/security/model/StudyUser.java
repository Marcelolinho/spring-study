package com.passtime.study.security.model;

import lombok.Data;

@Data
public class StudyUser {
    private String email;
    private String password;
    private String googleAuth;
}
