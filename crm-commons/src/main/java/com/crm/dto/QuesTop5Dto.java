package com.crm.dto;

import java.io.Serializable;

public class QuesTop5Dto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7610278586905937974L;

    private Long              quesId;

    private String            topPer;

    public String getTopPer() {
        return String.format("%.2f", Float.parseFloat(topPer));
    }

    public void setTopPer(String topPer) {
        this.topPer = topPer;
    }

    public Long getQuesId() {
        return quesId;
    }

    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

}
