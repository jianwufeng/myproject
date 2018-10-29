package com.crm.survey.controller.dto;

import java.util.List;

import com.crm.domain.backend.survey.Ques;
import com.crm.domain.backend.survey.QuesAnswerDetail;
import com.crm.domain.backend.survey.QuesSurvey;
import com.crm.domain.backend.survey.QuesType;

public class FormData {

    private QuesType               quesType;

    private QuesSurvey             quesSurvey;

    private Ques                   ques;

    private List<QuesAnswerDetail> quesAnswerDetailList;

    public QuesType getQuesType() {
        return quesType;
    }

    public void setQuesType(QuesType quesType) {
        this.quesType = quesType;
    }

    public QuesSurvey getQuesSurvey() {
        return quesSurvey;
    }

    public void setQuesSurvey(QuesSurvey quesSurvey) {
        this.quesSurvey = quesSurvey;
    }

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
