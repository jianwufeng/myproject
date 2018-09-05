package com.backend.survey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.crm.domain.backend.survey.QuesAnswerDetail;
import com.crm.domain.backend.survey.QuesAnswerDetailExample;

public interface QuesAnswerDetailMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int countByExample(QuesAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int deleteByExample(QuesAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int insert(QuesAnswerDetail record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int insertSelective(QuesAnswerDetail record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    List<QuesAnswerDetail> selectByExample(QuesAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    QuesAnswerDetail selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") QuesAnswerDetail record, @Param("example") QuesAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") QuesAnswerDetail record, @Param("example") QuesAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QuesAnswerDetail record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table t_an_ques_answer_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QuesAnswerDetail record);
}
