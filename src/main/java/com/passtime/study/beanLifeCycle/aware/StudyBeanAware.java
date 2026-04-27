package com.passtime.study.beanLifeCycle.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class StudyBeanAware implements BeanNameAware {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        // This is where I can control the beans names
        this.beanName = name;
    }
}
