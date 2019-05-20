package com.lpan.java_summarize.common.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lpan.java_summarize.common.user.entity.User;
import com.lpan.java_summarize.common.user.mapper.UserMapper;
import com.lpan.java_summarize.common.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lpan
 * @since 2019-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
