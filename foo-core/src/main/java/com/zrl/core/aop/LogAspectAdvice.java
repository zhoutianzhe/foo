//package com.zrl.core.aop;
//
//import ch.qos.logback.classic.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author zhouriliang
// * @date 2018-10-27
// */
//@Aspect
//@Component
//public class LogAspectAdvice {
//
//    private org.slf4j.Logger logger = LoggerFactory.getLogger(LogAspectAdvice.class);
//
//    //@Pointcut("execution(* ch.qos.logback.classic.Logger.*(..))")
//    //public void before() {
//    //}
//    //
//    //@Before("before()")
//    //public void beforeMethod(JoinPoint joinPoint) {
//    //    Object[] args = joinPoint.getArgs();
//    //    if(args == null || args.length ==0 ){
//    //        return;
//    //    }
//    //    for(Object obj : args){
//    //        if(obj instanceof String){
//    //            String traceId = EagleEye.getTraceId();
//    //            obj =  "traceId:" + traceId + " | " + obj;
//    //            break;
//    //        }
//    //    }
//    //}
//
//
//
//    @Pointcut("execution(* com.taobao.wlb.workplatform.core.service.WorkOrderServiceImpl.*(..))")
//    public void before() {
//    }
//
//    @Before("before()")
//    public void beforeMethod(JoinPoint joinPoint) {
//        logger.error(logger.getClass().getName());
//        logger.error("beforeMethod_xx_execute ...");
//    }
//
//}
