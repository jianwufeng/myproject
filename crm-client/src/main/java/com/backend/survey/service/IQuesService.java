package com.backend.survey.service;

import java.util.List;

import com.crm.domain.backend.survey.Ques;

public interface IQuesService {
    public List<Ques> getQuesByQuesId(String quesId);

    public void addQues(Ques ques);
}
