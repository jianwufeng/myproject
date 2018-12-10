package com.backend.survey.service;

import java.util.List;
import java.util.Map;

import com.crm.domain.backend.survey.QuesSurveyAnsweredDetail;
import com.crm.dto.QuesTop5Dto;
import com.crm.dto.SurveyCompanyPerDto;
import com.crm.dto.Top5Dto;

public interface IQuesSurveyAnsweredDetailService {

    public void batchInsert(List<QuesSurveyAnsweredDetail> detailList);

    public List<Top5Dto> getAgreeTop5(Long quesSurveyId);

    public List<Top5Dto> getDisAgreeTop5(Long quesSurveyId);

    public Map<Long, Top5Dto> getPerListByAnswer(Long quesSurveyId, String answerName);

    public SurveyCompanyPerDto getPerListByCompany(Long quesSurveyId);

    public List<QuesSurveyAnsweredDetail> getAnsweredDetailList(Long quesSurveyId);

    public List<QuesTop5Dto> getQuesAgreeTop5(Long quesSurveyId);

    public List<QuesTop5Dto> getQuesDisAgreeTop5(Long quesSurveyId);

}
