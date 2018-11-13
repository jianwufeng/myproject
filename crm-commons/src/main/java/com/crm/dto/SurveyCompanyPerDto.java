package com.crm.dto;

import java.io.Serializable;

public class SurveyCompanyPerDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7477587328699068796L;

    private String            companyName;

    private String            veryAgreePer;

    private String            agreePer;

    private String            partAgreePer;

    private String            disagreePer;

    private String            veryDisagreePer;

    private String            dontKnowPer;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getDisagreePer() {
        return disagreePer;
    }

    public void setDisagreePer(String disagreePer) {
        this.disagreePer = disagreePer;
    }

    public String getVeryDisagreePer() {
        return veryDisagreePer;
    }

    public void setVeryDisagreePer(String veryDisagreePer) {
        this.veryDisagreePer = veryDisagreePer;
    }

    public String getDontKnowPer() {
        return dontKnowPer;
    }

    public void setDontKnowPer(String dontKnowPer) {
        this.dontKnowPer = dontKnowPer;
    }

}
