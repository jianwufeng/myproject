package com.backend.survey.service;

import java.util.List;

import com.crm.domain.backend.survey.QuesSurvey;

public interface IQuesSurveyService {

    void addQuesSurvey(QuesSurvey quesSurvey);

    List<QuesSurvey> queryQuesSurvey(int page, int limit);

    List<QuesSurvey> queyQuesSurveyByCondition(QuesSurvey quesSurvey);

    int countQuesSurvey();

    void updateByCondition(QuesSurvey quesSurvey);

    QuesSurvey getQuesSurveyById(Long quesSurveyId);
}
