package com.lpan.java_summarize.config;


import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/***
 * 数据源配置类
 *
 */
@Configuration
/** 扫描mapper接口文件 */
@MapperScan(basePackages ={"com.lpan.java_summarize.*.*.mapper"},sqlSessionFactoryRef="sqlSessionFactoryBean" )
public class DataSourceConfig {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);


    @Bean(name = "hikariDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new HikariDataSource();
    }

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hikariDataSource") DataSource dataSource,
                                               @Qualifier(value = "globalConfig")GlobalConfig globalConfig,
                                               PaginationInterceptor paginationInterceptor){
        try{
            MybatisSqlSessionFactoryBean mybatisSqlSessionFactory = new MybatisSqlSessionFactoryBean();
            mybatisSqlSessionFactory.setDataSource(dataSource);
            Interceptor[] interceptors = new Interceptor[]{paginationInterceptor};
            mybatisSqlSessionFactory.setPlugins(interceptors);
            mybatisSqlSessionFactory.setGlobalConfig(globalConfig);
            mybatisSqlSessionFactory.setTypeAliasesPackage("com.lpan.java_summarize.common.**.model");
            mybatisSqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:spring/mybatis-config.xml"));
            mybatisSqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
            SqlSessionFactory sqlSessionFactory = mybatisSqlSessionFactory.getObject();
            return sqlSessionFactory;
        }catch (Exception e){
            logger.error("初始化sqlSessionFactoryBean1出现异常:",e);
            return null;
        }

    }

    @ConfigurationProperties(prefix = "global-config1")
    @Bean(name = "globalConfig")
    public GlobalConfig globalConfiguration1() {
        logger.info("初始化globalConfiguration");
        return new GlobalConfig();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager1(@Qualifier("hikariDataSource") DataSource dataSource) {
        logger.info("初始化transactionManager");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryBean") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

}
