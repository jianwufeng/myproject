package com.backend.survey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesTypeMapper;
import com.backend.survey.service.IQuesTypeService;
import com.crm.domain.backend.survey.QuesType;

@Service("quesTypeService")
public class QuesTypeServiceImpl implements IQuesTypeService {

    @Autowired
    private QuesTypeMapper quesTypeMapper;

    @Override
    public void addQuesType(QuesType quesType) {
        quesTypeMapper.insertSelective(quesType);
    }
}
