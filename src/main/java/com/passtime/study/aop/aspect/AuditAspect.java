package com.passtime.study.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AuditAspect {

    @Before("@annotation(ValidateProductStock)")
    public void validateProductStock(ProceedingJoinPoint joinPoint) {
        log.info("[AUDIT] validando estoque do produto");

        joinPoint.get
    }
}
