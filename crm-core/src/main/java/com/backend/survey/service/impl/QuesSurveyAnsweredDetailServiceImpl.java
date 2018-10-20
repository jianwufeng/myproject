package com.backend.survey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesSurveyAnsweredDetailMapper;
import com.backend.survey.service.IQuesSurveyAnsweredDetailService;
import com.crm.domain.backend.survey.QuesSurveyAnsweredDetail;

@Service("quesSurveyAnsweredDetailService")
public class QuesSurveyAnsweredDetailServiceImpl implements IQuesSurveyAnsweredDetailService {

    @Autowired
    private QuesSurveyAnsweredDetailMapper quesSurveyAnsweredDetailMapper;

    @Override
    public void batchInsert(List<QuesSurveyAnsweredDetail> detailList) {
        for (QuesSurveyAnsweredDetail quesSurveyAnsweredDetail : detailList) {
            quesSurveyAnsweredDetailMapper.insertSelective(quesSurveyAnsweredDetail);
        }
    }
}
