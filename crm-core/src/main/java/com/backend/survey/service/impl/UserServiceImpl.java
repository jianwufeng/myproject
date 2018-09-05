package com.backend.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.UserMapper;
import com.backend.survey.service.IUserService;
import com.crm.domain.backend.survey.User;
import com.crm.domain.backend.survey.UserExample;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByCondition(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(user.getEmail());
        return userMapper.selectByExample(example);
    }

}
