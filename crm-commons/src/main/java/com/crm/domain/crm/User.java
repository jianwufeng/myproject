package com.crm.domain.crm;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /** 用户id */
    private Integer id;

    /** 用户代码 */
    private String userCode;

    /** 名字 */
    private String userName;

    /** 英文名字 */
    private String englishName;

    /** 性别 */
    private Integer gender;

    /** 职位 */
    private String positionTitle;

    /** 手机 */
    private String mobilePhone;

    /** 座机 */
    private String telePhone;

    /** 座机2 */
    private String telePhone2;

    /** 直线号 */
    private String directNo;

    /** 邮箱 */
    private String email;

    /** 密码 */
    private String password;

    /** QQ */
    private String qq;

    /** 微信 */
    private String weixin;

    /** 头像 */
    private String avatar;

    /** 状态:1.正常,2离职 */
    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer derma;

    private Long createUserId;

    private Long updateUserId;

    /** 离职用户操作人id */
    private Long dimissionOperator;

    /** 离职用户操作时间 */
    private Date dimissionOperateTime;

    /** 删除用户操作人id */
    private Long deleteOperator;

    /** 删除用户操作时间 */
    private Date deleteOperateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.id
     *
     * @return the value of tb_user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.id
     *
     * @param id the value for tb_user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_code
     *
     * @return the value of tb_user.user_code
     *
     * @mbggenerated
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_code
     *
     * @param userCode the value for tb_user.user_code
     *
     * @mbggenerated
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_name
     *
     * @return the value of tb_user.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_name
     *
     * @param userName the value for tb_user.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.english_name
     *
     * @return the value of tb_user.english_name
     *
     * @mbggenerated
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.english_name
     *
     * @param englishName the value for tb_user.english_name
     *
     * @mbggenerated
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.gender
     *
     * @return the value of tb_user.gender
     *
     * @mbggenerated
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.gender
     *
     * @param gender the value for tb_user.gender
     *
     * @mbggenerated
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.position_title
     *
     * @return the value of tb_user.position_title
     *
     * @mbggenerated
     */
    public String getPositionTitle() {
        return positionTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.position_title
     *
     * @param positionTitle the value for tb_user.position_title
     *
     * @mbggenerated
     */
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.mobile_phone
     *
     * @return the value of tb_user.mobile_phone
     *
     * @mbggenerated
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.mobile_phone
     *
     * @param mobilePhone the value for tb_user.mobile_phone
     *
     * @mbggenerated
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.tele_phone
     *
     * @return the value of tb_user.tele_phone
     *
     * @mbggenerated
     */
    public String getTelePhone() {
        return telePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.tele_phone
     *
     * @param telePhone the value for tb_user.tele_phone
     *
     * @mbggenerated
     */
    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.tele_phone2
     *
     * @return the value of tb_user.tele_phone2
     *
     * @mbggenerated
     */
    public String getTelePhone2() {
        return telePhone2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.tele_phone2
     *
     * @param telePhone2 the value for tb_user.tele_phone2
     *
     * @mbggenerated
     */
    public void setTelePhone2(String telePhone2) {
        this.telePhone2 = telePhone2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.direct_no
     *
     * @return the value of tb_user.direct_no
     *
     * @mbggenerated
     */
    public String getDirectNo() {
        return directNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.direct_no
     *
     * @param directNo the value for tb_user.direct_no
     *
     * @mbggenerated
     */
    public void setDirectNo(String directNo) {
        this.directNo = directNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.email
     *
     * @return the value of tb_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.email
     *
     * @param email the value for tb_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.password
     *
     * @return the value of tb_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.password
     *
     * @param password the value for tb_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.qq
     *
     * @return the value of tb_user.qq
     *
     * @mbggenerated
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.qq
     *
     * @param qq the value for tb_user.qq
     *
     * @mbggenerated
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.weixin
     *
     * @return the value of tb_user.weixin
     *
     * @mbggenerated
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.weixin
     *
     * @param weixin the value for tb_user.weixin
     *
     * @mbggenerated
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.avatar
     *
     * @return the value of tb_user.avatar
     *
     * @mbggenerated
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.avatar
     *
     * @param avatar the value for tb_user.avatar
     *
     * @mbggenerated
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.status
     *
     * @return the value of tb_user.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.status
     *
     * @param status the value for tb_user.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.create_time
     *
     * @return the value of tb_user.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.create_time
     *
     * @param createTime the value for tb_user.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.update_time
     *
     * @return the value of tb_user.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.update_time
     *
     * @param updateTime the value for tb_user.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.derma
     *
     * @return the value of tb_user.derma
     *
     * @mbggenerated
     */
    public Integer getDerma() {
        return derma;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.derma
     *
     * @param derma the value for tb_user.derma
     *
     * @mbggenerated
     */
    public void setDerma(Integer derma) {
        this.derma = derma;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.create_user_id
     *
     * @return the value of tb_user.create_user_id
     *
     * @mbggenerated
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.create_user_id
     *
     * @param createUserId the value for tb_user.create_user_id
     *
     * @mbggenerated
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.update_user_id
     *
     * @return the value of tb_user.update_user_id
     *
     * @mbggenerated
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.update_user_id
     *
     * @param updateUserId the value for tb_user.update_user_id
     *
     * @mbggenerated
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.dimission_operator
     *
     * @return the value of tb_user.dimission_operator
     *
     * @mbggenerated
     */
    public Long getDimissionOperator() {
        return dimissionOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.dimission_operator
     *
     * @param dimissionOperator the value for tb_user.dimission_operator
     *
     * @mbggenerated
     */
    public void setDimissionOperator(Long dimissionOperator) {
        this.dimissionOperator = dimissionOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.dimission_operate_time
     *
     * @return the value of tb_user.dimission_operate_time
     *
     * @mbggenerated
     */
    public Date getDimissionOperateTime() {
        return dimissionOperateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.dimission_operate_time
     *
     * @param dimissionOperateTime the value for tb_user.dimission_operate_time
     *
     * @mbggenerated
     */
    public void setDimissionOperateTime(Date dimissionOperateTime) {
        this.dimissionOperateTime = dimissionOperateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.delete_operator
     *
     * @return the value of tb_user.delete_operator
     *
     * @mbggenerated
     */
    public Long getDeleteOperator() {
        return deleteOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.delete_operator
     *
     * @param deleteOperator the value for tb_user.delete_operator
     *
     * @mbggenerated
     */
    public void setDeleteOperator(Long deleteOperator) {
        this.deleteOperator = deleteOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.delete_operate_time
     *
     * @return the value of tb_user.delete_operate_time
     *
     * @mbggenerated
     */
    public Date getDeleteOperateTime() {
        return deleteOperateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.delete_operate_time
     *
     * @param deleteOperateTime the value for tb_user.delete_operate_time
     *
     * @mbggenerated
     */
    public void setDeleteOperateTime(Date deleteOperateTime) {
        this.deleteOperateTime = deleteOperateTime;
    }
}