package com.backend.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesMapper;
import com.backend.survey.service.IQuesService;
import com.crm.domain.backend.survey.Ques;
import com.crm.domain.backend.survey.QuesExample;

@Service("quesService")
public class QuesServiceImpl implements IQuesService {
    @Autowired
    private QuesMapper quesMapper;

    @Override
    public List<Ques> getQuesByQuesId(String quesId) {
        QuesExample example = new QuesExample();
        example.createCriteria().andQuesIdEqualTo(quesId);
        return quesMapper.selectByExample(example);
    }

    @Override
    public void addQues(Ques ques) {
        quesMapper.insertSelective(ques);
    }

}
