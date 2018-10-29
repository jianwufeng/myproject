package com.crm.survey.controller.dto;

import com.crm.domain.backend.survey.QuesSurvey;

public class QuesSurveyDto extends QuesSurvey {
    /**
     */
    private static final long serialVersionUID = 1761717258842973393L;
    private String            file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

}
