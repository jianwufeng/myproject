package com.backend.survey.service;

import java.util.List;
import java.util.Map;

import com.crm.domain.backend.survey.Ques;

public interface IQuesService {
    public List<Ques> getQuesByQuesId(Long quesId);

    public void addQues(Ques ques);

    List<Ques> queryQues(Long quesSurveyId, List<Long> quesTypeIds);

    Map<Long, List<Ques>> queryQuesMap(Long quesSurveyId, List<Long> quesTypeIds);

    Ques queryQuesById(Long quesId);

    public List<Ques> queryQuesList(int page, int limit);
}
