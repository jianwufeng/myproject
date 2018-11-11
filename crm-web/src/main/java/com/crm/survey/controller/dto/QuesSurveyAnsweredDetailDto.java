package com.crm.survey.controller.dto;

import java.io.Serializable;

public class QuesSurveyAnsweredDetailDto implements Serializable {
    /**
     */
    private static final long serialVersionUID = -9187538836871083855L;

    private Long              quesSurveyId;

    private Long              quesTypeId;

    private Long              quesId;

    private String            quesName;

    private String            typeName;

    private String            answerName;

    private Integer           isBackgroundSurvey;

    public Long getQuesSurveyId() {
        return quesSurveyId;
    }

    public void setQuesSurveyId(Long quesSurveyId) {
        this.quesSurveyId = quesSurveyId;
    }

    public Long getQuesTypeId() {
        return quesTypeId;
    }

    public void setQuesTypeId(Long quesTypeId) {
        this.quesTypeId = quesTypeId;
    }

    public Long getQuesId() {
        return quesId;
    }

    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public Integer getIsBackgroundSurvey() {
        return isBackgroundSurvey;
    }

    public void setIsBackgroundSurvey(Integer isBackgroundSurvey) {
        this.isBackgroundSurvey = isBackgroundSurvey;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
