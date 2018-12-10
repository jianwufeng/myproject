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

    private List<String>      quesNameAgreeList;

    private List<String>      quesPerAgreeList;

    private List<String>      quesNameDisAgreeList;

    private List<String>      quesPerDisAgreeList;

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

    public List<String> getQuesNameAgreeList() {
        return quesNameAgreeList;
    }

    public void setQuesNameAgreeList(List<String> quesNameAgreeList) {
        this.quesNameAgreeList = quesNameAgreeList;
    }

    public List<String> getQuesPerAgreeList() {
        return quesPerAgreeList;
    }

    public void setQuesPerAgreeList(List<String> quesPerAgreeList) {
        this.quesPerAgreeList = quesPerAgreeList;
    }

    public List<String> getQuesNameDisAgreeList() {
        return quesNameDisAgreeList;
    }

    public void setQuesNameDisAgreeList(List<String> quesNameDisAgreeList) {
        this.quesNameDisAgreeList = quesNameDisAgreeList;
    }

    public List<String> getQuesPerDisAgreeList() {
        return quesPerDisAgreeList;
    }

    public void setQuesPerDisAgreeList(List<String> quesPerDisAgreeList) {
        this.quesPerDisAgreeList = quesPerDisAgreeList;
    }

}
