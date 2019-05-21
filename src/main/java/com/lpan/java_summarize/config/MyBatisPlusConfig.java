package com.lpan.java_summarize.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liwei
 * @date 2019/2/27 1:59 PM
 */
@Configuration
public class MyBatisPlusConfig {

   /**
    * Description
    * @author lpan
    * @date 19-5-16
    * @date 下午3:45
    * @param  * @param
    * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
    */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }
}
