package com.backend.survey.service;

import java.util.List;

import com.crm.domain.backend.survey.User;

public interface IUserService {

    List<User> getUserByCondition(User user);

    void updateUserByCondition(User user);
}
