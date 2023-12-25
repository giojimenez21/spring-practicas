package com.spring.aop.springaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {
    @Pointcut("execution(String com.spring.aop.springaop..*.*(..)")
    private void greetingLoggerPointCut(){}
}
