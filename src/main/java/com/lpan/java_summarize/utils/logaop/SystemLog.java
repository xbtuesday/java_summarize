package com.lpan.java_summarize.utils.logaop;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    /**类名*/
    String cname() default "";

    /**方法名*/
    String mname() default "";

}
