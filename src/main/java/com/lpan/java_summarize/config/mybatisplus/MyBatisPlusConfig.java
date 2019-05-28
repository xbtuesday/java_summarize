//package com.lpan.java_summarize.config.mybatisplus;
//
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Profile;
//
///**
// * @author liwei
// * @date 2019/2/27 1:59 PM
// */
////@Configuration
//public class MyBatisPlusConfig {
//
//   /**
//    * Description  mybatis plus 分页插件配置
//    * @author lpan
//    * @date 19-5-16
//    * @date 下午3:45
//    * @param  * @param
//    * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
//    */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }
//
//    /**性能分析插件*/
//    @Bean
//    /**作用域为 开发和测试的时候 */
//    @Profile({"dev","test"})
//    public PerformanceInterceptor performanceInterceptor(){
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        /**设置sql最大执行时长*/
//        performanceInterceptor.setMaxTime(1000);
//        /**是否格式化  默认是false*/
//        performanceInterceptor.setFormat(true);
//        /**设置属性*/
//        //performanceInterceptor.setProperties();
//        return new PerformanceInterceptor();
//    }
//}
