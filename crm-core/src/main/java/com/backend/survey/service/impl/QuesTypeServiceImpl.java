package com.backend.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesTypeMapper;
import com.backend.survey.service.IQuesTypeService;
import com.crm.domain.backend.survey.QuesType;
import com.crm.domain.backend.survey.QuesTypeExample;
import com.crm.domain.backend.survey.QuesTypeExample.Criteria;

@Service("quesTypeService")
public class QuesTypeServiceImpl implements IQuesTypeService {

    @Autowired
    private QuesTypeMapper quesTypeMapper;

    @Override
    public void addQuesType(QuesType quesType) {
        quesTypeMapper.insertSelective(quesType);
    }

    @Override
    public List<QuesType> queryQuesTypeList(Long quesSurveyId) {
        QuesTypeExample example = new QuesTypeExample();
        example.createCriteria().andQuesSurveyIdEqualTo(quesSurveyId);
        return quesTypeMapper.selectByExample(example);
    }

    @Override
    public List<QuesType> queryQuesTypeList(int page, int limit) {
        QuesTypeExample example = new QuesTypeExample();
        Criteria criteria = example.createCriteria();
        return quesTypeMapper.selectByExample(example);
    }
}
