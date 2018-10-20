package com.backend.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesSurveyMapper;
import com.backend.survey.service.IQuesSurveyService;
import com.crm.domain.backend.survey.QuesSurvey;
import com.crm.domain.backend.survey.QuesSurveyExample;

@Service("quesSurveyService")
public class QuesSurveyServiceImpl implements IQuesSurveyService {

    @Autowired
    private QuesSurveyMapper quesSurveyMapper;

    @Override
    public void addQuesSurvey(QuesSurvey quesSurvey) {
        quesSurveyMapper.insertSelective(quesSurvey);
    }

    @Override
    public List<QuesSurvey> queryQuesSurvey() {
        QuesSurveyExample example = new QuesSurveyExample();
        return quesSurveyMapper.selectByExample(example);
    }

    @Override
    public List<QuesSurvey> queyQuesSurveyByCondition(QuesSurvey quesSurvey) {
        QuesSurveyExample example = new QuesSurveyExample();
        example.createCriteria().andQuesSurveyIdEqualTo(quesSurvey.getQuesSurveyId());
        return quesSurveyMapper.selectByExample(example);
    }
}
