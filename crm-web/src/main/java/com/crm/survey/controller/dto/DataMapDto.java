package com.crm.survey.controller.dto;

import java.io.Serializable;
import java.util.Set;

public class DataMapDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 3188928097899987299L;

    private Set<String>       quesTypeNameAgreeList;

    private Set<String>       quesTypePerAgreeList;

    private Set<String>       quesTypeNameDisAgreeList;

    private Set<String>       quesTypePerDisAgreeList;

    public Set<String> getQuesTypeNameAgreeList() {
        return quesTypeNameAgreeList;
    }

    public void setQuesTypeNameAgreeList(Set<String> quesTypeNameAgreeList) {
        this.quesTypeNameAgreeList = quesTypeNameAgreeList;
    }

    public Set<String> getQuesTypePerAgreeList() {
        return quesTypePerAgreeList;
    }

    public void setQuesTypePerAgreeList(Set<String> quesTypePerAgreeList) {
        this.quesTypePerAgreeList = quesTypePerAgreeList;
    }

    public Set<String> getQuesTypeNameDisAgreeList() {
        return quesTypeNameDisAgreeList;
    }

    public void setQuesTypeNameDisAgreeList(Set<String> quesTypeNameDisAgreeList) {
        this.quesTypeNameDisAgreeList = quesTypeNameDisAgreeList;
    }

    public Set<String> getQuesTypePerDisAgreeList() {
        return quesTypePerDisAgreeList;
    }

    public void setQuesTypePerDisAgreeList(Set<String> quesTypePerDisAgreeList) {
        this.quesTypePerDisAgreeList = quesTypePerDisAgreeList;
    }

}
