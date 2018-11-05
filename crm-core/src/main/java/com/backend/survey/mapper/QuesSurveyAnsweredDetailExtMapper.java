package com.backend.survey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.crm.dto.SurveyCompanyPerDto;
import com.crm.dto.Top5Dto;

public interface QuesSurveyAnsweredDetailExtMapper extends QuesSurveyAnsweredDetailMapper {

    List<Top5Dto> getAgreeTop5(Long quesSurveyId);

    List<Top5Dto> getDisAgreeTop5(Long quesSurveyId);

    List<Top5Dto> getPerListByAnswer(@Param("quesSurveyId") Long quesSurveyId, @Param("answerName") String answerName);

    SurveyCompanyPerDto getPerListByCompany(Long quesSurveyId);
}
