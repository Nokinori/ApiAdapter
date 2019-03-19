package com.api.server.handlers.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class Logging {

    @Pointcut("@annotation(Loggable)")
    public void loggable() {
    }

    @Before("loggable()")
    public void logBefore(JoinPoint joinPoint) {
        String msg;
        if (joinPoint.getArgs().length > 0) {
            msg = "Before {}";
            log.trace(msg, joinPoint.toShortString());
        } else {
            msg = "Before {} with args: {}";
            log.trace(msg, joinPoint.toShortString(), Arrays.toString(joinPoint.getArgs()));
        }
    }

    @After("loggable()")
    public void logAfter(JoinPoint joinPoint) {
        String msg;
        if (joinPoint.getArgs().length > 0) {
            msg = "After {}";
            log.trace(msg, joinPoint.toShortString());
        } else {
            msg = "After {} with args: {}";
            log.trace(msg, joinPoint.toShortString(), Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(pointcut = "loggable()", returning = "object")
    public void logAfterReturning(Object object) {
        System.out.println(object);
    }


    @Around("execution(* com.api.server.GenericServlet.get())")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }

}
