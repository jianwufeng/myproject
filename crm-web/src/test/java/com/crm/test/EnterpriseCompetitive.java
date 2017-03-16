package com.crm.test;

/**
 * Date: 2017年2月16日 上午11:26:24
 * 
 * @author Jihan
 */
public class EnterpriseCompetitive {

    private String enterpriseId;
    private String name;
    private String displayName;
    private Float compositeIndex; // 综合指数
    private Integer countPosition; // 职位数

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCompositeIndex() {
        return compositeIndex;
    }

    public void setCompositeIndex(Float compositeIndex) {
        this.compositeIndex = compositeIndex;
    }

    public Integer getCountPosition() {
        return countPosition;
    }

    public void setCountPosition(Integer countPosition) {
        this.countPosition = countPosition;
    }

}
