package com.lpan.java_summarize.config.springdatajpa;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: DataSourceConfig
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 05:11
 * Version: 1.0
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "hikariDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariDataSource hikariDataSource(){
        return new HikariDataSource();
    }
}
