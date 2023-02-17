package com.example.demoSpringBootPropertiesLoggingAOPValidation.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
@Configuration
@Aspect
public class ServiceAspect {
    private final Logger LOGGER =  LoggerFactory.getLogger(ServiceAspect.class);
    @Before("execution(* com.example.demoSpringBootPropertiesLoggingAOPValidation.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        LOGGER.info("before called "+ joinPoint.toString());
    }
    @After("execution(* com.example.demoSpringBootPropertiesLoggingAOPValidation.service.*.*(..))")
    public void after(JoinPoint joinPoint){
        LOGGER.info("after called "+ joinPoint.toString());
    }
    @AfterThrowing("execution(* com.example.demoSpringBootPropertiesLoggingAOPValidation.service.*.*(..))")
    public void afterWithBreak(JoinPoint joinPoint){
        LOGGER.info("error at "+ joinPoint.toString());
    }
}
