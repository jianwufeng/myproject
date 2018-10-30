package com.backend.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesSurveyMapper;
import com.backend.survey.service.IQuesSurveyService;
import com.crm.domain.backend.survey.QuesSurvey;
import com.crm.domain.backend.survey.QuesSurveyExample;
import com.crm.util.mybatis.plugin.Limit;

@Service("quesSurveyService")
public class QuesSurveyServiceImpl implements IQuesSurveyService {

    @Autowired
    private QuesSurveyMapper quesSurveyMapper;

    @Override
    public void addQuesSurvey(QuesSurvey quesSurvey) {
        quesSurveyMapper.insertSelective(quesSurvey);
    }

    @Override
    public List<QuesSurvey> queryQuesSurvey(int page, int limit) {
        QuesSurveyExample example = new QuesSurveyExample();
        example.setOrderByClause("ques_survey_id desc");
        example.setLimit(new Limit((page - 1) * limit, limit));
        example.createCriteria().andIsDeleteEqualTo(false);
        return quesSurveyMapper.selectByExample(example);
    }

    @Override
    public List<QuesSurvey> queyQuesSurveyByCondition(QuesSurvey quesSurvey) {
        QuesSurveyExample example = new QuesSurveyExample();
        example.createCriteria().andQuesSurveyIdEqualTo(quesSurvey.getQuesSurveyId()).andIsDeleteEqualTo(false);
        return quesSurveyMapper.selectByExample(example);
    }

    @Override
    public int countQuesSurvey() {
        QuesSurveyExample example = new QuesSurveyExample();
        example.createCriteria().andIsDeleteEqualTo(false);
        return quesSurveyMapper.countByExample(example);
    }

    @Override
    public void updateByCondition(QuesSurvey quesSurvey) {
        QuesSurveyExample example = new QuesSurveyExample();
        example.createCriteria().andQuesSurveyIdEqualTo(quesSurvey.getQuesSurveyId());
        quesSurveyMapper.updateByExampleSelective(quesSurvey, example);
    }

    @Override
    public QuesSurvey getQuesSurveyById(Long quesSurveyId) {
        return quesSurveyMapper.selectByPrimaryKey(quesSurveyId);
    }
}
