package com.crm.survey.controller.dto;

import java.util.List;

import com.crm.domain.backend.survey.QuesSurveyAnsweredDetail;

public class FormData {

    private List<QuesSurveyAnsweredDetail> ansDetailList;

    public List<QuesSurveyAnsweredDetail> getAnsDetailList() {
        return ansDetailList;
    }

    public void setAnsDetailList(List<QuesSurveyAnsweredDetail> ansDetailList) {
        this.ansDetailList = ansDetailList;
    }

}
