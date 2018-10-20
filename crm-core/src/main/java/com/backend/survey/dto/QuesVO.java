package com.backend.survey.dto;

import java.io.Serializable;
import java.util.List;

import com.crm.domain.backend.survey.Ques;
import com.crm.domain.backend.survey.QuesAnswerDetail;

public class QuesVO extends Ques implements Serializable {

    /**
     */
    private static final long      serialVersionUID = 5434988852090588348L;

    private List<QuesAnswerDetail> quesAnswerDetailList;;

    public List<QuesAnswerDetail> getQuesAnswerDetailList() {
        return quesAnswerDetailList;
    }

    public void setQuesAnswerDetailList(List<QuesAnswerDetail> quesAnswerDetailList) {
        this.quesAnswerDetailList = quesAnswerDetailList;
    }

}
