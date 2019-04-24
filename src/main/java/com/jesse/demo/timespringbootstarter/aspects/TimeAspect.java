package com.jesse.demo.timespringbootstarter.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class TimeAspect {

    @Autowired
    private FormatProperties formatProperties;



    @Pointcut("@annotation(com.jesse.demo.timespringbootstarter.annotation.Time)")
    public void point() {
    }

//    @Before("point()")
//    public void logStart(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + "方法运行开始 参数为{" + Arrays.asList(joinPoint.getArgs()) + "}");
//    }
//
//    @After("point()")
//    public void logEnd(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + "方法运行结束 参数为{" + Arrays.asList(joinPoint.getArgs()) + "}");
//    }

//    @AfterReturning(value = "point()", returning = "result")
//    public void logReturn(JoinPoint joinPoint, Object result) {
//        System.out.println(joinPoint.getSignature() + "方法运行返回 返回值为{" + result.toString() + "}");
//    }
//
//    @AfterThrowing(value = "point()", throwing = "e")
//    public void logException(JoinPoint joinPoint, Exception e) {
//        System.out.println(joinPoint.getSignature() + "方法运行异常 异常为{" + e + "}");
//    }

    @Around(value = "point()")
    public Object logAround(ProceedingJoinPoint jp) throws Throwable{
        SimpleDateFormat f = new SimpleDateFormat(formatProperties.getFormat());
        Date start = new Date();
        System.out.println("----------------------------------- "+f.format(start)+" 开始执行---------------------------------------------------------");
        Object proceed = jp.proceed();
        Date end = new Date();
        System.out.println("-----------------------------------方法 "+jp.getSignature()+"执行 花费 :  "+(end.getTime()-start.getTime())+"ms-----------");
        System.out.println("----------------------------------- "+f.format(end)+" 结束执行---------------------------------------------------------");
        return proceed;
    }

}
