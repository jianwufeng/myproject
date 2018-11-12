package com.crm.survey.controller.dto;

import java.io.Serializable;

import com.crm.util.excel.ExportExcelPar;

public class QuesSurveyAnsweredDetailDto implements Serializable {
    /**
     */
    private static final long serialVersionUID = -9187538836871083855L;

    private Long              quesSurveyId;

    @ExportExcelPar(ifExport = false)
    private Long              quesTypeId;

    private String            quesTypeName;

    private Long              quesId;

    private String            quesName;

    private String            typeName;

    private String            answerName;

    @ExportExcelPar(ifExport = false)
    private Integer           isBackgroundSurvey;

    private String            isBackgroundSurveyStr;

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

    public String getQuesTypeName() {
        return quesTypeName;
    }

    public void setQuesTypeName(String quesTypeName) {
        this.quesTypeName = quesTypeName;
    }

    public String getIsBackgroundSurveyStr() {
        return isBackgroundSurveyStr;
    }

    public void setIsBackgroundSurveyStr(String isBackgroundSurveyStr) {
        this.isBackgroundSurveyStr = isBackgroundSurveyStr;
    }

}
