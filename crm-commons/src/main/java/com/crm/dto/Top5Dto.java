package com.crm.dto;

import java.io.Serializable;

public class Top5Dto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7610278586905937974L;

    private Long              quesTypeId;

    private String            topPer;

    public Long getQuesTypeId() {
        return quesTypeId;
    }

    public void setQuesTypeId(Long quesTypeId) {
        this.quesTypeId = quesTypeId;
    }

    public String getTopPer() {
        return topPer;
    }

    public void setTopPer(String topPer) {
        this.topPer = topPer;
    }

}
