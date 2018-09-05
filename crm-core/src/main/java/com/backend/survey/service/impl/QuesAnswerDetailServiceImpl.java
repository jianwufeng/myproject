package com.backend.survey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesAnswerDetailMapper;
import com.backend.survey.service.IQuesAnswerDetailService;
import com.crm.domain.backend.survey.QuesAnswerDetail;

@Service("quesAnswerDetailService")
public class QuesAnswerDetailServiceImpl implements IQuesAnswerDetailService {

    @Autowired
    private QuesAnswerDetailMapper quesAnswerDetailMapper;
    @Override
    public void addQuesAnswerDetail(QuesAnswerDetail aser) {
        quesAnswerDetailMapper.insertSelective(aser);
    }
}
