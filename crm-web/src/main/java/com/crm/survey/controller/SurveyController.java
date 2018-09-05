package com.crm.survey.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.backend.survey.service.IQuesAnswerDetailService;
import com.backend.survey.service.IQuesService;
import com.backend.survey.service.IQuesSurveyAnsweredDetailService;
import com.backend.survey.service.IQuesSurveyService;
import com.backend.survey.service.IQuesTypeService;
import com.backend.survey.service.IUserService;
import com.crm.RestResponseEntity;
import com.crm.common.res.ResultVO;
import com.crm.domain.backend.survey.Ques;
import com.crm.domain.backend.survey.QuesAnswerDetail;
import com.crm.domain.backend.survey.QuesSurvey;
import com.crm.domain.backend.survey.QuesType;
import com.crm.domain.backend.survey.User;

@Controller
//@RequestMapping("survey")
public class SurveyController {

    @Autowired
    private IQuesService                     quesService;

    @Autowired
    private IQuesTypeService                 quesTypeService;

    @Autowired
    private IQuesSurveyService               quesSurveyServive;

    @Autowired
    private IQuesAnswerDetailService         quesAnswerDetailService;

    @Autowired
    private IQuesSurveyAnsweredDetailService quesSurveyAnsweredDetailService;

    @Autowired
    private IUserService                     userService;

    @ResponseBody
    @RequestMapping(value = "getName", method = RequestMethod.GET)
    public String getName(@RequestParam(value = "quesId", required = true) String quesId) {
        List<Ques> quesList = quesService.getQuesByQuesId(quesId);
        return quesList.get(0).getQuesName();
    }

    @RequestMapping(value = "loginFtl", method = RequestMethod.GET)
    public String loginFtl() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public RestResponseEntity login(@RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true) String password) {
        User user = new User();
        user.setEmail(email);
        List<User> userList = userService.getUserByCondition(user);
        if (CollectionUtils.isNotEmpty(userList)) {
            if (!password.equals(userList.get(0).getPassword())) {
                //return "密码不正确";
            }
        } else {
            //return "用户名不存在";
        }
        return RestResponseEntity.getEntity(true);
    }

    /*
     * @RequestMapping(value = "index", method = RequestMethod.GET) public
     * String indexFtl() { return "index"; }
     */

    @RequestMapping(value = "addQuesSurvey", method = RequestMethod.GET)
    public ModelAndView addQuesSurvey(@RequestParam(value = "surveyName", required = true) String surveyName, @RequestParam(value = "logoUrl", required = true) String logoUrl,
                                      @RequestParam(value = "surveyRemarks", required = true) String surveyRemarks,
                                      @RequestParam(value = "surveyTitle", required = true) String surveyTitle,
                                      @RequestParam(value = "surveyTotal", required = true) String surveyTotal) {

        QuesSurvey quesSurvey = new QuesSurvey();
        quesSurvey.setQuesSurveyId(System.currentTimeMillis() + "");
        quesSurvey.setQuesSurveyLogoUrl(logoUrl);
        quesSurvey.setQuesSurveyName(surveyName);
        quesSurvey.setQuesSurveyRemarks(surveyRemarks);
        quesSurvey.setQuesSurveyTitle(surveyTitle);

        quesSurveyServive.addQuesSurvey(quesSurvey);

        return new ModelAndView("layout");
    }

    @RequestMapping(value = "addQuesType", method = RequestMethod.POST)
    public String addQuesType(@RequestParam(value = "quesTypeId", required = true) String quesTypeId, @RequestParam(value = "quesTypeName", required = true) String quesTypeName,
                              @RequestParam(value = "quesSurveyId", required = true) String quesSurveyId, @RequestParam(value = "order", required = true) Integer order) {

        QuesType type = new QuesType();
        type.setOrderById(order);
        type.setQuesSurveyId(quesSurveyId);
        type.setQuesTypeId(quesTypeId);
        type.setQuesTypeName(quesTypeName);
        quesTypeService.addQuesType(type);
        return "SUCCESS";
    }

    @RequestMapping(value = "addQues", method = RequestMethod.POST)
    public String addQues(@RequestParam(value = "quesId", required = true) String quesId, @RequestParam(value = "quesName", required = true) String quesName,
                          @RequestParam(value = "quesSurveyId", required = true) String quesSurveyId, @RequestParam(value = "quesTypeId", required = true) String quesTypeId,
                          @RequestParam(value = "quesType", required = true) Integer quesType, @RequestParam(value = "order", required = true) Integer order) {

        Ques ques = new Ques();
        ques.setQuesId(quesId);
        ques.setQuesName(quesName);
        ques.setQuesSurveyId(quesSurveyId);
        ques.setQuesTypeId(quesTypeId);
        ques.setQuesType(quesType);
        ques.setOrderById(order);
        quesService.addQues(ques);
        return "SUCCESS";
    }

    @RequestMapping(value = "addQuesAnswerDetail", method = RequestMethod.POST)
    public String addQuesAnswerDetail(@RequestParam(value = "quesSurveyId", required = true) String quesSurveyId,
                                      @RequestParam(value = "quesTypeId", required = true) String quesTypeId, @RequestParam(value = "quesId", required = true) String quesId,
                                      @RequestParam(value = "quesName", required = true) String quesName, @RequestParam(value = "answerId", required = true) String answerId,
                                      @RequestParam(value = "answerName", required = true) String answerName, @RequestParam(value = "optionId", required = true) String optionId,
                                      @RequestParam(value = "order", required = true) Integer order) {

        QuesAnswerDetail aser = new QuesAnswerDetail();
        aser.setQuesSurveyId(quesSurveyId);
        aser.setQuesTypeId(quesTypeId);
        aser.setQuesId(quesId);
        aser.setQuesName(quesName);
        aser.setAnswerId(answerId);
        aser.setAnswerName(answerName);
        aser.setOptionId(optionId);
        aser.setOrderById(order);
        quesAnswerDetailService.addQuesAnswerDetail(aser);
        return "SUCCESS";
    }

    @ResponseBody
    @RequestMapping(value = "queryQuesSurveyList", method = RequestMethod.GET)
    public ResultVO queryQuesSurveyList(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = true) int limit) {
        List<QuesSurvey> surveyList = quesSurveyServive.queryQuesSurvey();
        String jsons = JSON.toJSONString(surveyList);
        ResultVO vo = new ResultVO();
        vo.setCode("SUCCESS");
        vo.setMsg("SUCCESS");
        vo.setCount(11);
        vo.setData(surveyList);
        return vo;
    }
}
