package com.catmanscodes.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterThrowing(
            pointcut = "execution(* com.catmanscodes.controller.*.*(..))) || execution(* com.catmanscodes.service.*.*(..))",
            throwing = "ex")
    public void logAfterThrowingError(JoinPoint joinPoint, Throwable ex) {
        LOGGER.error("Hi CatMan :) , An exception was thrown in method: "
                + joinPoint.getSignature().getName() + " of class: "
                + joinPoint.getSignature().getDeclaringTypeName() + ". Exception message: "
                + ex.getMessage());
    }

}
