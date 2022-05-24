package com.gmail.arthurstrokov.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    
    @Pointcut("@annotation(com.gmail.arthurstrokov.annotation.LoggableController)")
    public void annotatedController() {
    }
    
    @Around("annotatedController()")
    public Object logController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        log.info("#### Method: {}, requestURL: {}, body: {}", request.getMethod(), request.getRequestURI(), proceedingJoinPoint.getArgs());
        Object value = proceedingJoinPoint.proceed();
        log.info("Request result: {}", value);
        return value;
    }
}
