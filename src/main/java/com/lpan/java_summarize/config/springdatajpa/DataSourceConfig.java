package com.lpan.java_summarize.config.springdatajpa;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * ClassName: DataSourceConfig
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 05:11
 * Version: 1.0
 */
@Configuration
/**启用事物管理*/
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean(name = "hikariDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariDataSource hikariDataSource(){
        return new HikariDataSource();
    }

    /**配置实体类管理器*/
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
                                                                       @Qualifier("hikariDataSource") HikariDataSource hikariDataSource
                                                                       ,@Qualifier("hibernateJpaVendorAdapter") HibernateJpaVendorAdapter hibernateJpaVendorAdapter
                                                                        ){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        /**设置数据源*/
        localContainerEntityManagerFactoryBean.setDataSource(hikariDataSource);
        /**扫描实体类所在的包*/
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.lpan.java_summarize.common.**.model");
        /***/
        localContainerEntityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        /**设置数据厂商*/
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        return localContainerEntityManagerFactoryBean;
    }

    /**设置数据库厂商设置*/
    @Bean("hibernateJpaVendorAdapter")
    @ConfigurationProperties(prefix = "spring.jpa")
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        /**数据库类型*/
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        /**生成ddl语句 -- 不（false）*/
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        /**
         * 数据库方言
         * org.hibernate.dialect.MySQL5InnoDBDialect  存储引擎为InnoDb
         * org.hibernate.dialect.MySQL5Dialect  默认为MyISAM
         **/
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

        return hibernateJpaVendorAdapter;
    }

    /** 事务配置 */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("hikariDataSource") HikariDataSource hikariDataSource,
                                                                 EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(hikariDataSource);
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }


}
