package com.backend.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.UserMapper;
import com.backend.survey.service.IUserService;
import com.crm.domain.backend.survey.User;
import com.crm.domain.backend.survey.UserExample;
import com.crm.domain.backend.survey.UserExample.Criteria;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByCondition(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(user.getUserName());
        return userMapper.selectByExample(example);
    }

    @Override
    public void updateUserByCondition(User user) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        userMapper.updateByExampleSelective(user, example);
    }

}
