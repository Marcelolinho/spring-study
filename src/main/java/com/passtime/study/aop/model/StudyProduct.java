package com.passtime.study.aop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyProduct {
    private Long id;
    private String name;
    private int quantity;
}
