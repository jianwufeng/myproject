package com.crm.service;

import java.util.List;
import java.util.Map;

import com.crm.domain.crm.User;

public interface IUserService {

    List<User> getAll(int start, int pagesize);

    User getById(Integer userId);

    /**
     * 
     * 功能描述: <br>
     * 根据用户id获取正常状态下的用户
     *
     * @param userIds
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<User> getActiveUserByIds(List<Integer> userIds);

    /**
     * 获取一批用户ID对应的用户名称
     *
     * @param userIds 一批用户ID
     * @return 已用户ID为键，用户姓名为值的map返回，如果userIds为空，则返回空Map
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<Integer, String> getUserNames(List<Integer> userIds);

    public String getUserName(Integer userId);

}