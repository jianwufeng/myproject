package com.crm.domain.backend.survey;

import java.io.Serializable;
import java.util.Date;

public class Ques implements Serializable {
    private Long id;

    /** 题目ID */
    private String quesId;

    /** 题目名称 */
    private String quesName;

    /** 题目类型 1：单选，2：多选，3：填空 */
    private Integer quesType;

    /** 所属问卷ID */
    private String quesSurveyId;

    /** 所属题目大类ID */
    private String quesTypeId;

    /** 排序 */
    private Integer orderById;

    /** 是否可见 */
    private Boolean isDelete;

    /** 是否必答 */
    private Boolean isRequired;

    private Date createTime;

    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_an_ques
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.id
     *
     * @return the value of t_an_ques.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.id
     *
     * @param id the value for t_an_ques.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.ques_id
     *
     * @return the value of t_an_ques.ques_id
     *
     * @mbggenerated
     */
    public String getQuesId() {
        return quesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.ques_id
     *
     * @param quesId the value for t_an_ques.ques_id
     *
     * @mbggenerated
     */
    public void setQuesId(String quesId) {
        this.quesId = quesId == null ? null : quesId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.ques_name
     *
     * @return the value of t_an_ques.ques_name
     *
     * @mbggenerated
     */
    public String getQuesName() {
        return quesName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.ques_name
     *
     * @param quesName the value for t_an_ques.ques_name
     *
     * @mbggenerated
     */
    public void setQuesName(String quesName) {
        this.quesName = quesName == null ? null : quesName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.ques_type
     *
     * @return the value of t_an_ques.ques_type
     *
     * @mbggenerated
     */
    public Integer getQuesType() {
        return quesType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.ques_type
     *
     * @param quesType the value for t_an_ques.ques_type
     *
     * @mbggenerated
     */
    public void setQuesType(Integer quesType) {
        this.quesType = quesType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.ques_survey_id
     *
     * @return the value of t_an_ques.ques_survey_id
     *
     * @mbggenerated
     */
    public String getQuesSurveyId() {
        return quesSurveyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.ques_survey_id
     *
     * @param quesSurveyId the value for t_an_ques.ques_survey_id
     *
     * @mbggenerated
     */
    public void setQuesSurveyId(String quesSurveyId) {
        this.quesSurveyId = quesSurveyId == null ? null : quesSurveyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.ques_type_id
     *
     * @return the value of t_an_ques.ques_type_id
     *
     * @mbggenerated
     */
    public String getQuesTypeId() {
        return quesTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.ques_type_id
     *
     * @param quesTypeId the value for t_an_ques.ques_type_id
     *
     * @mbggenerated
     */
    public void setQuesTypeId(String quesTypeId) {
        this.quesTypeId = quesTypeId == null ? null : quesTypeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.order_by_id
     *
     * @return the value of t_an_ques.order_by_id
     *
     * @mbggenerated
     */
    public Integer getOrderById() {
        return orderById;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.order_by_id
     *
     * @param orderById the value for t_an_ques.order_by_id
     *
     * @mbggenerated
     */
    public void setOrderById(Integer orderById) {
        this.orderById = orderById;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.is_delete
     *
     * @return the value of t_an_ques.is_delete
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.is_delete
     *
     * @param isDelete the value for t_an_ques.is_delete
     *
     * @mbggenerated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.is_required
     *
     * @return the value of t_an_ques.is_required
     *
     * @mbggenerated
     */
    public Boolean getIsRequired() {
        return isRequired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.is_required
     *
     * @param isRequired the value for t_an_ques.is_required
     *
     * @mbggenerated
     */
    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.create_time
     *
     * @return the value of t_an_ques.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.create_time
     *
     * @param createTime the value for t_an_ques.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_an_ques.update_time
     *
     * @return the value of t_an_ques.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_an_ques.update_time
     *
     * @param updateTime the value for t_an_ques.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}