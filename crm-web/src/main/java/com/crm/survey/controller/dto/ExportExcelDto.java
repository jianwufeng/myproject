package com.crm.survey.controller.dto;

import java.io.Serializable;

public class ExportExcelDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -623819890517693974L;

    private String            quesTypeName;

    private String            veryAgreePer;

    private String            agreePer;

    private String            partAgreePer;

    private String            disAgreePer;

    private String            veryDisAgreePer;

    public String getQuesTypeName() {
        return quesTypeName;
    }

    public void setQuesTypeName(String quesTypeName) {
        this.quesTypeName = quesTypeName;
    }

    public String getVeryAgreePer() {
        return veryAgreePer;
    }

    public void setVeryAgreePer(String veryAgreePer) {
        this.veryAgreePer = veryAgreePer;
    }

    public String getAgreePer() {
        return agreePer;
    }

    public void setAgreePer(String agreePer) {
        this.agreePer = agreePer;
    }

    public String getPartAgreePer() {
        return partAgreePer;
    }

    public void setPartAgreePer(String partAgreePer) {
        this.partAgreePer = partAgreePer;
    }

    public String getDisAgreePer() {
        return disAgreePer;
    }

    public void setDisAgreePer(String disAgreePer) {
        this.disAgreePer = disAgreePer;
    }

    public String getVeryDisAgreePer() {
        return veryDisAgreePer;
    }

    public void setVeryDisAgreePer(String veryDisAgreePer) {
        this.veryDisAgreePer = veryDisAgreePer;
    }

}
