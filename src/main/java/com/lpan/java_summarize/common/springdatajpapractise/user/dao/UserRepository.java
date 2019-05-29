package com.lpan.java_summarize.common.springdatajpapractise.user.dao;

import com.lpan.java_summarize.common.springdatajpapractise.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: UserRepository
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 06:04
 * Version: 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor {

    /**
     * Description  根据年龄查询用户
     * @author lpan
     * @date 27/05/19
     * @date 下午 06:56
     * @param  * @param age
     * @return com.lpan.java_summarize.common.springdatajpapractise.user.model.User
     */
    List<User> findByAge(Integer age);

    /***
     * Description  根据姓名查询
     *          使用CONCAT 进行 sql like语句的拼接
     *
     * @author lpan
     * @date 27/05/19
     * @date 下午 07:25
     * @param  * @param name
     * @return java.util.List<com.lpan.java_summarize.common.springdatajpapractise.user.model.User>
     */
    @Query(value = "select u from User u where u.name like CONCAT('%',:name,'%')")
    List<User> findByNameLike(String name);




}
