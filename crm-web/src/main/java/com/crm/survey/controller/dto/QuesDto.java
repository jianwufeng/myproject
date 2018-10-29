package com.crm.survey.controller.dto;

import java.util.List;

import com.crm.domain.backend.survey.Ques;
import com.crm.domain.backend.survey.QuesAnswerDetail;

public class QuesDto {

    private Ques                   ques;

    private List<QuesAnswerDetail> quesAnswerDetailList;

    public Ques getQues() {
        return ques;
    }

    public void setQues(Ques ques) {
        this.ques = ques;
    }

    public List<QuesAnswerDetail> getQuesAnswerDetailList() {
        return quesAnswerDetailList;
    }

    public void setQuesAnswerDetailList(List<QuesAnswerDetail> quesAnswerDetailList) {
        this.quesAnswerDetailList = quesAnswerDetailList;
    }

}
