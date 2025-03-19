package com.app.vitalsign.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResponseTimeAspect {
    @Around("execution(* com.app.vitalsign.controller.*.*(..))")  // Change package as needed
    public Object measureResponseTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // Proceed with the method execution
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        // Log the response time
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method [" + methodName + "] took " + responseTime + " ms");

        return result;
    }
}
