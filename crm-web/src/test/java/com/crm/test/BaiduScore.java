package com.crm.test;

import java.io.Serializable;

/**
 * Date: 2017年2月18日 下午2:39:33
 * 
 * @author Jihan
 */
public class BaiduScore implements Serializable {

    private static final long serialVersionUID = 1L;

    private float baidusearchscore = 0;
    // 百度搜索分数
    private float baiduzhaopingscore = 0;
    // 百度招聘分数
    private Integer baiduzhaopingall = 0;
    // 百度招聘总职位数
    private Integer baiduzhaopingbeijing = 0;
    // 百度招聘北京职位数
    private Integer baiduzhaopingshanghai = 0;
    // 百度招聘上海职位数
    private Integer baiduzhaopingshenzheng = 0;
    // 百度招聘深圳职位数
    private Integer baiduzhaopingguangzhou = 0;
    // 百度招聘广州职位数
    private Integer baiduzhaopingother = 0;
    // 百度招聘其他城市职位数
    private Integer baiduzhaoping1W22W = 0;
    // 百度招聘月薪1-2W职位
    private Integer baiduzhaoping2W23W = 0;
    // 百度招聘月薪2-3W职位
    private Integer baiduzhaoping3W25W = 0;
    // 百度招聘月薪3-5W职位
    private Integer baiduzhaoping5W = 0;
    // 百度招聘月薪5W以上职位
    private Integer baiduzhaoping1W = 0;
    // 百度招聘月薪1W以下
    private float score = 0;

    // 综合评分
    public float getBaidusearchscore() {
        return baidusearchscore;
    }

    public void setBaidusearchscore(float baidusearchscore) {
        this.baidusearchscore = baidusearchscore;
    }

    public float getBaiduzhaopingscore() {
        return baiduzhaopingscore;
    }

    public void setBaiduzhaopingscore(float baiduzhaopingscore) {
        this.baiduzhaopingscore = baiduzhaopingscore;
    }

    public Integer getBaiduzhaopingall() {
        return baiduzhaopingall;
    }

    public void setBaiduzhaopingall(Integer baiduzhaopingall) {
        this.baiduzhaopingall = baiduzhaopingall;
    }

    public Integer getBaiduzhaopingbeijing() {
        return baiduzhaopingbeijing;
    }

    public void setBaiduzhaopingbeijing(Integer baiduzhaopingbeijing) {
        this.baiduzhaopingbeijing = baiduzhaopingbeijing;
    }

    public Integer getBaiduzhaopingshanghai() {
        return baiduzhaopingshanghai;
    }

    public void setBaiduzhaopingshanghai(Integer baiduzhaopingshanghai) {
        this.baiduzhaopingshanghai = baiduzhaopingshanghai;
    }

    public Integer getBaiduzhaopingshenzheng() {
        return baiduzhaopingshenzheng;
    }

    public void setBaiduzhaopingshenzheng(Integer baiduzhaopingshenzheng) {
        this.baiduzhaopingshenzheng = baiduzhaopingshenzheng;
    }

    public Integer getBaiduzhaopingguangzhou() {
        return baiduzhaopingguangzhou;
    }

    public void setBaiduzhaopingguangzhou(Integer baiduzhaopingguangzhou) {
        this.baiduzhaopingguangzhou = baiduzhaopingguangzhou;
    }

    public Integer getBaiduzhaopingother() {
        return baiduzhaopingother;
    }

    public void setBaiduzhaopingother(Integer baiduzhaopingother) {
        this.baiduzhaopingother = baiduzhaopingother;
    }

    public Integer getBaiduzhaoping1W22W() {
        return baiduzhaoping1W22W;
    }

    public void setBaiduzhaoping1W22W(Integer baiduzhaoping1w22w) {
        baiduzhaoping1W22W = baiduzhaoping1w22w;
    }

    public Integer getBaiduzhaoping2W23W() {
        return baiduzhaoping2W23W;
    }

    public void setBaiduzhaoping2W23W(Integer baiduzhaoping2w23w) {
        baiduzhaoping2W23W = baiduzhaoping2w23w;
    }

    public Integer getBaiduzhaoping3W25W() {
        return baiduzhaoping3W25W;
    }

    public void setBaiduzhaoping3W25W(Integer baiduzhaoping3w25w) {
        baiduzhaoping3W25W = baiduzhaoping3w25w;
    }

    public Integer getBaiduzhaoping5W() {
        return baiduzhaoping5W;
    }

    public void setBaiduzhaoping5W(Integer baiduzhaoping5w) {
        baiduzhaoping5W = baiduzhaoping5w;
    }

    public Integer getBaiduzhaoping1W() {
        return baiduzhaoping1W;
    }

    public void setBaiduzhaoping1W(Integer baiduzhaoping1w) {
        baiduzhaoping1W = baiduzhaoping1w;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

}
