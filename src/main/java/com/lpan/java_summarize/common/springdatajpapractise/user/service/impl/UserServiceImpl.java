package com.lpan.java_summarize.common.springdatajpapractise.user.service.impl;

import com.lpan.java_summarize.common.springdatajpapractise.user.dao.UserRepository;
import com.lpan.java_summarize.common.springdatajpapractise.user.model.User;
import com.lpan.java_summarize.common.springdatajpapractise.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: UserServiceImpl
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 06:14
 * Version: 1.0
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public int updateById(User user) {
        User user1 = userRepository.saveAndFlush(user);
        int flag = 0;
        if (null !=user1){
            flag = 1;
        }
        return flag;
    }

    @Override
    public User selectById(Integer id) {
        User one = userRepository.getOne(id);
        return one;
    }

    @Override
    public List<User> findByAge(Integer age) {
        List<User> users = userRepository.findByAge(age);
        return users;
    }

    @Override
    public List<User> findByNameLike(String name) {
        List<User> byName = userRepository.findByNameLike(name);
        return byName;
    }

    /**
     *
     *  jpa 动态sql
     *
     * */
    @Override
    @Transactional
    public List<User> findByCondition(String name, Integer age, Integer id) {
        List<Predicate> list = new ArrayList<>(4);
        Specification specification = (root,query,criteriaBuilder)->{
            if (null != id && !"".equals(id)){
                Predicate name1 = criteriaBuilder.like(root.get("name"), name);
                list.add(name1);
            }
            if (null != age && !"".equals(age)){
                Predicate age1 = criteriaBuilder.lessThan(root.get("age"), age);
                list.add(age1);
            }
            if (null != age && !"".equals(age)){
                Predicate id1 = criteriaBuilder.equal(root.get("id"), id);
                list.add(id1);
            }
            Predicate and = criteriaBuilder.or(list.toArray(new Predicate[list.size()]));
            return and;
        };
        List<User> all = userRepository.findAll(specification);
        return all;
    }
}
