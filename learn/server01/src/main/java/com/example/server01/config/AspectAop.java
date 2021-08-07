package com.example.server01.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class AspectAop {
/*
    @Autowired
    MeterCounterConfig meterCounterConfig;

    @Pointcut("execution(public * com.example.server01.controller.*.*(..))")
    private void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint)throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        meterCounterConfig.methodCounter(methodName);
    }

    @AfterReturning(returning = "returnVal", pointcut = "pointCut()")
    public void doAftereReturning(Object returnVal){

    }*/
}
