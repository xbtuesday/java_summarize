package com.lpan.java_summarize.jpadatatest;

import com.lpan.java_summarize.BaseTest;
import com.lpan.java_summarize.common.springdatajpapractise.user.dao.UserRepository;
import com.lpan.java_summarize.common.springdatajpapractise.user.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ClassName: JpaTest
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 06:58
 * Version: 1.0
 */
public class JpaTest extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public String getbyage(){
        List<User> users = userRepository.findByAge(18);
        User user = users.get(0);
        return user.toString();
    }





}
