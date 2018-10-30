package com.backend.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesTypeMapper;
import com.backend.survey.service.IQuesTypeService;
import com.crm.domain.backend.survey.QuesType;
import com.crm.domain.backend.survey.QuesTypeExample;
import com.crm.util.mybatis.plugin.Limit;

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
        example.setOrderByClause("ques_type_id desc");
        example.setLimit(new Limit((page - 1) * limit, limit));
        example.createCriteria().andIsDeleteEqualTo(false);
        return quesTypeMapper.selectByExample(example);
    }

    @Override
    public QuesType getById(Long quesTypeId) {
        return quesTypeMapper.selectByPrimaryKey(quesTypeId);
    }

    @Override
    public int countQuesType() {
        QuesTypeExample example = new QuesTypeExample();
        example.createCriteria().andIsDeleteEqualTo(false);
        return quesTypeMapper.countByExample(example);
    }

    @Override
    public void updateQuesType(QuesType quesType) {
        QuesTypeExample example = new QuesTypeExample();
        example.createCriteria().andQuesTypeIdEqualTo(quesType.getQuesTypeId());
        quesTypeMapper.updateByExampleSelective(quesType, example);
    }
}
