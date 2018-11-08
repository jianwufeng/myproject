package com.backend.survey.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesSurveyMapper;
import com.backend.survey.service.IQuesSurveyService;
import com.crm.domain.backend.survey.QuesSurvey;
import com.crm.domain.backend.survey.QuesSurveyExample;
import com.github.pagehelper.PageHelper;

@Service("quesSurveyService")
public class QuesSurveyServiceImpl implements IQuesSurveyService {

    @Autowired
    private QuesSurveyMapper quesSurveyMapper;

    @Override
    public void addQuesSurvey(QuesSurvey quesSurvey) {
        quesSurvey.setCreateTime(new Date());
        quesSurvey.setUpdateTime(new Date());
        quesSurveyMapper.insertSelective(quesSurvey);
    }

    @Override
    public List<QuesSurvey> queryQuesSurvey(int page, int limit) {
        QuesSurveyExample example = new QuesSurveyExample();
        example.setOrderByClause("ques_survey_id desc");
        //example.setLimit(new Limit((page - 1) * limit, limit));
        PageHelper.startPage(page, limit, false);
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
        quesSurvey.setUpdateTime(new Date());
        QuesSurveyExample example = new QuesSurveyExample();
        example.createCriteria().andQuesSurveyIdEqualTo(quesSurvey.getQuesSurveyId());
        quesSurveyMapper.updateByExampleSelective(quesSurvey, example);
    }

    @Override
    public QuesSurvey getQuesSurveyById(Long quesSurveyId) {
        return quesSurveyMapper.selectByPrimaryKey(quesSurveyId);
    }
}
