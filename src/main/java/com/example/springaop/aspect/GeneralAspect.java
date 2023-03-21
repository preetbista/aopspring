package com.example.springaop.aspect;

import com.example.springaop.model.Department;
import com.example.springaop.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralAspect {
    @Pointcut("execution(* com.example.springaop.controller.*.*(..))")
    public void loggingPointCut() {}

   /* @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("Before method invoke::"+ joinPoint.getSignature());
    }*/

   /* @After("loggingPointCut()")
    public void after(JoinPoint joinPoint){
        log.info("After method invoke::"+ joinPoint.getSignature());
    }*/

     /*@AfterReturning(value = "execution(* com.example.springaop.controller.*.*(..))",
             returning = "employee")
    public void after(JoinPoint joinPoint, Employee employee){
        log.info("After method invoke::"+ employee);
    }

    @AfterThrowing(value = "execution(* com.example.springaop.controller.*.*(..))",
            throwing = "e")
    public void after(JoinPoint joinPoint, Exception e){
        log.info("After method invoke::"+ e.getMessage());
    }*/

      @Around("loggingPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("Before method invoke::"+ joinPoint.getArgs()[0]);
        Object object = joinPoint.proceed();

        if(object instanceof Employee){
            log.info("After method invoked..."+ joinPoint.getArgs()[0]);
        }else if(object instanceof Department){
            log.info("After method invoked..."+ joinPoint.getArgs()[0]);
        }

        return object;
    }

}
