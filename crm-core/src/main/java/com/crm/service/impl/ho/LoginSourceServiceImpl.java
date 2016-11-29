package com.crm.service.impl.ho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.ho.loginsource.mapper.LoginSourceMapper;
import com.crm.domain.ho.LoginSource;
import com.ho.service.ILoginSourceService;

@Service
public class LoginSourceServiceImpl implements ILoginSourceService {

    @Autowired
    private LoginSourceMapper loginSourceMapper;

    @Override
    public LoginSource getLoginSource(Long id) {
        return loginSourceMapper.selectByPrimaryKey(id);
    }
}
