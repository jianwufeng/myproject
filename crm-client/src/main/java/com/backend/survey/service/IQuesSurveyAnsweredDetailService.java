package com.backend.survey.service;

import java.util.List;

import com.crm.domain.backend.survey.QuesSurveyAnsweredDetail;

public interface IQuesSurveyAnsweredDetailService {

    public void batchInsert(List<QuesSurveyAnsweredDetail> detailList);
}
