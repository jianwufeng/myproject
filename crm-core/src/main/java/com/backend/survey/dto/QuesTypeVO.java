package com.backend.survey.dto;

import java.io.Serializable;
import java.util.List;

import com.crm.domain.backend.survey.QuesType;

public class QuesTypeVO extends QuesType implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4236340934680006299L;

    private List<QuesVO>      quesList;

    public List<QuesVO> getQuesList() {
        return quesList;
    }

    public void setQuesList(List<QuesVO> quesList) {
        this.quesList = quesList;
    }

}
