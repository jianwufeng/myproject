package com.crm.service.impl.crm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.crm.user.mapper.UserMapper;
import com.crm.domain.crm.User;
import com.crm.domain.crm.UserExample;
import com.crm.service.IUserService;
import com.crm.util.mybatis.plugin.Limit;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll(int start, int pagesize) {
        UserExample example = new UserExample();
        example.createCriteria().andStatusEqualTo(1);
        example.setLimit(new Limit(start, pagesize));
        return userMapper.selectByExample(example);
    }

    @Override
    public com.crm.domain.crm.User getById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Map<Integer, String> getUserNames(List<Integer> userIds) {
        Map<Integer, String> nameMap = new HashMap<Integer, String>();
        if (CollectionUtils.isNotEmpty(userIds)) {
            List<User> users = getActiveUserByIds(userIds);
            if (CollectionUtils.isNotEmpty(users)) {
                for (User user : users) {
                    nameMap.put(user.getId(), user.getUserName());
                }
            }
        }
        return nameMap;
    }

    @Override
    public String getUserName(Integer userId) {
        String name = "";
        User user = getById(userId);
        if (user != null) {
            name = user.getUserName();
        }
        return name;
    }

    @Override
    public List<User> getActiveUserByIds(List<Integer> userIds) {
        // TODO Auto-generated method stub
        return null;
    }

}