package com.backend.survey.mapper;

import com.crm.domain.backend.survey.QuesSurvey;
import com.crm.domain.backend.survey.QuesSurveyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuesSurveyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int countByExample(QuesSurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int deleteByExample(QuesSurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long quesSurveyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int insert(QuesSurvey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int insertSelective(QuesSurvey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    List<QuesSurvey> selectByExample(QuesSurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    QuesSurvey selectByPrimaryKey(Long quesSurveyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") QuesSurvey record, @Param("example") QuesSurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") QuesSurvey record, @Param("example") QuesSurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QuesSurvey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_an_ques_survey
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QuesSurvey record);
}