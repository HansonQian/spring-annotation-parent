package com.hanson.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    /**
     * 抽取公共的切入点表达式
     * 1、本类直接使用方法名
     * 2、外部类引用需要使用本方法的全限定名称
     */
    @Pointcut("execution(public int com.hanson.service.MathCalculatorService.*(..))")
    public void pointCut() {

    }


    /**
     * 在目标方法执行前切入
     * 切入点表达式(指定在哪个方法切入)
     */
    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(" " + joinPoint.getSignature().getName() + "运行--@Before注解-参数列表是:{" + Arrays.asList(joinPoint.getArgs()) + "}");
    }

    /**
     * 在目标方法执行之后执行不论目标方法是否正常执行本方法都会被执行
     */
    @After("com.hanson.aspect.LogAspect.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(" " + joinPoint.getSignature().getName() + "结束---@After注解");
    }

    @AfterReturning(value = "pointCut()", returning = "ret")
    public void logReturn(JoinPoint joinPoint, Object ret) {
        System.out.println(" " + joinPoint.getSignature().getName() + "正常返回--@AfterReturning注解--返回结果:{" + ret + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e) {
        System.out.println(" " + joinPoint.getSignature().getName() + "异常---异常信息:{" + e.getMessage() + "}");
    }
}
