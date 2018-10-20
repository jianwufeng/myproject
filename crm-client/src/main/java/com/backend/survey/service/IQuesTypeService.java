package com.backend.survey.service;

import java.util.List;

import com.crm.domain.backend.survey.QuesType;

public interface IQuesTypeService {

    void addQuesType(QuesType type);

    List<QuesType> queryQuesTypeList(Long quesSurveyId);

    List<QuesType> queryQuesTypeList(int page, int limit);
}
