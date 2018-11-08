package com.crm.survey.controller.dto;

import java.io.Serializable;
import java.util.List;

public class DataMapDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 3188928097899987299L;

    private List<String>      quesTypeNameAgreeList;

    private List<String>      quesTypePerAgreeList;

    private List<String>      quesTypeNameDisAgreeList;

    private List<String>      quesTypePerDisAgreeList;

    public List<String> getQuesTypeNameAgreeList() {
        return quesTypeNameAgreeList;
    }

    public void setQuesTypeNameAgreeList(List<String> quesTypeNameAgreeList) {
        this.quesTypeNameAgreeList = quesTypeNameAgreeList;
    }

    public List<String> getQuesTypePerAgreeList() {
        return quesTypePerAgreeList;
    }

    public void setQuesTypePerAgreeList(List<String> quesTypePerAgreeList) {
        this.quesTypePerAgreeList = quesTypePerAgreeList;
    }

    public List<String> getQuesTypeNameDisAgreeList() {
        return quesTypeNameDisAgreeList;
    }

    public void setQuesTypeNameDisAgreeList(List<String> quesTypeNameDisAgreeList) {
        this.quesTypeNameDisAgreeList = quesTypeNameDisAgreeList;
    }

    public List<String> getQuesTypePerDisAgreeList() {
        return quesTypePerDisAgreeList;
    }

    public void setQuesTypePerDisAgreeList(List<String> quesTypePerDisAgreeList) {
        this.quesTypePerDisAgreeList = quesTypePerDisAgreeList;
    }

}
