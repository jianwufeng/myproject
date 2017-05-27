package com.crm.domain.user;

import java.util.Date;

import com.crm.domain.BaseDO;

/**
 * 
 * @author haisheng.long Mon Apr 13 17:21:49 CST 2015
 */

public class UserDetailDO extends BaseDO {

    /**
     * <pre>
     * 
     * </pre>
     */
    private static final long serialVersionUID = 1521869673719334622L;

    /** 主键 */
    private Long id;

    /** 用户id */
    private Long userId;

    /** 手机 */
    private String mobile;

    /** 地址 */
    private String address;

    /** 邮编 */
    private String zipCode;

    /** email */
    private String email;

    /** 传真 */
    private String fax;

    /** qq */
    private String qq;

    /** 固定电话 */
    private String fixedPhone;

    /** 性别 0:女 1:男 */
    private Integer sex;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date modifyTime;

    /** 状态 0:不可用 1:可用 */
    private Boolean state;

    /**
     * 设置 主键
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置 用户id
     * 
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 设置 手机
     * 
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 设置 email
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 设置 传真
     * 
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 设置
     * 
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 设置 固定电话
     * 
     * @param fixedPhone
     */
    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    /**
     * 设置
     * 
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 设置 创建时间
     * 
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 设置 修改时间
     * 
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 设置
     * 
     * @param state
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取 主键
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 获取 用户id
     * 
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 获取 手机
     * 
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 获取 email
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 获取 传真
     * 
     * @return fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * 获取
     * 
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * 获取 固定电话
     * 
     * @return fixedPhone
     */
    public String getFixedPhone() {
        return fixedPhone;
    }

    /**
     * 获取
     * 
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 获取 创建时间
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 获取 修改时间
     * 
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 获取
     * 
     * @return state
     */
    public Boolean getState() {
        return state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "UserDetailDO [id=" + id + ", userId=" + userId + ", mobile=" + mobile + ", address=" + address + ", zipCode=" + zipCode + ", email=" + email
                + ", fax=" + fax + ", qq=" + qq + ", fixedPhone=" + fixedPhone + ", sex=" + sex + ", createTime=" + createTime + ", modifyTime=" + modifyTime
                + ", state=" + state + "]";
    }

}