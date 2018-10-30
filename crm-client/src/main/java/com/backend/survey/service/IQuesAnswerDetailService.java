package com.backend.survey.service;

import java.util.List;
import java.util.Map;

import com.crm.domain.backend.survey.Ques;
import com.crm.domain.backend.survey.QuesAnswerDetail;

public interface IQuesAnswerDetailService {

    void addQuesAnswerDetail(QuesAnswerDetail aser);

    List<QuesAnswerDetail> queryQuesAnswerDetailList(Long quesSurveyId, List<Long> quesIds);

    Map<Long, List<QuesAnswerDetail>> queryQuesAnswerDetailMap(Long quesSurveyId, List<Long> quesIds);

    List<QuesAnswerDetail> queryQuesAnswerListPage(int page, int limit);

    int countQuesAnswer();

    Map<Ques, List<QuesAnswerDetail>> queryQuesAnswerDetailMapBy(Long quesSurveyId, List<Long> quesIds);

    int updateQuesAnswerDetail(QuesAnswerDetail quesAnswerDetail);

}
