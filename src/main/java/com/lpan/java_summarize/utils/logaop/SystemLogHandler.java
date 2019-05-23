package com.lpan.java_summarize.utils.logaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 * ClassName: SystemLogAop  日志拦截器
 * Description: TODO
 * Author: lpan
 * Date 19-5-23 下午2:14
 * Version: 1.0
 */
@Component
@Aspect
@Slf4j
public class SystemLogHandler {

    private final Logger logger = LoggerFactory.getLogger(SystemLogHandler.class);


    /**定义一个切点*/
    @Pointcut(value = "@annotation(com.lpan.java_summarize.utils.logaop.SystemLog)")
    public void syslog(){}

    /**前置通知*/
    @Before(value = "syslog()")
    public void before(){
        System.out.println("===========日志记录开始===========");
    }

    /**前置通知*/
    @After(value = "syslog()")
    public void after(){
        System.out.println("===========日志记录结束==========");
    }

    /**后置通知*/
    @Around(value = "syslog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        /**获取request*/
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        if (null == proceedingJoinPoint){
            return null;
        }
        Object proceed = null;
        /**注解所在的类名*/
        String cname = proceedingJoinPoint.getTarget().getClass().getName();
        /**注解所在的方法名*/
        String mname = proceedingJoinPoint.getSignature().getName();

        /**获取方法的参数*/
        Object[] args = proceedingJoinPoint.getArgs();
        Arrays.asList(args).forEach(arg-> System.out.println("参数:" + arg));
        try {
            logger.info("**************************方法开始执行**********************");
            /**开始时间毫秒数*/
            long beginsecond = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
            /**执行目标方法*/
            proceed = proceedingJoinPoint.proceed();
            /**结束时间毫秒数*/
            long endsecond = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
            System.out.println("耗时:" + (endsecond-beginsecond));
            logger.info("**************************方法结束执行**********************");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(proceed);
        return proceed;
    }




}
