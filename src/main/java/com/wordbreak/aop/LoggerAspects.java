package com.wordbreak.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.aop
 * @create 2020-02-22
 * project running process logging
 */
@Slf4j
@Aspect
@Component
public class LoggerAspects {

    @Pointcut("execution(public * com.wordbreak.controller.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logBefor(JoinPoint joinPoint) {
        log.info("Full class name is [{}]", joinPoint.getSignature().getDeclaringTypeName());
        log.info("[{}] the befor parameter is [{}]", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @After("pointCut()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("[{}] the befor parameter is already finish running", joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointCut()", returning = "o")
    public void logAfterReturn(Object o) {
        log.info("the running result is [{}]", o);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(Exception e) {
        log.error("the running result is [{}]", e);
    }

}
