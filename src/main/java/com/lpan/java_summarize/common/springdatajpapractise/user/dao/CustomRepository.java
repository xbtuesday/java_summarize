package com.lpan.java_summarize.common.springdatajpapractise.user.dao;

import com.lpan.java_summarize.base.jdk8.stream.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * ClassName: CustomRepository   动态sql
 *   jpa 提供了动态sql  JpaSpecificationExecutor
 *   使用的方法；  跟其他接口一样 也是继承  JpaSpecificationExecutor
 *   JpaSpecificationExecutor 接口 提供多个条件查询方法
 *      这些方法都有一个共同的特点就是  方法的参数都是需要传一个 Specification<T>  而JpaSpecificationExecutor 基本是围绕Specification
 *      Specification这个接口 中只定义了一个方法：
 *          Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);
 *          参数： Root :实例是类型化 定义了查询的from子句中能够出现的类型 root代表查询的实体类
 *                CriteriaQuery<T>:
 *                CriteriaBuilder接口:用来构建CritiaQuery的构建器对象Predicate
 *
 * Description: TODO
 * Author: lpan
 * Date 29/05/19 下午 02:33
 * Version: 1.0
 */
public interface CustomRepository extends CrudRepository<User, Integer> , JpaSpecificationExecutor {

    List<User> findByCondition(String name, String age, String sex);

}
