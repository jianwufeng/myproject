package com.crm.survey.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.survey.dto.QuesSurveyVO;
import com.backend.survey.dto.QuesTypeVO;
import com.backend.survey.dto.QuesVO;
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
import com.crm.domain.backend.survey.QuesSurveyAnsweredDetail;
import com.crm.domain.backend.survey.QuesType;
import com.crm.domain.backend.survey.User;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import edu.emory.mathcs.backport.java.util.Arrays;

@Controller
//@RequestMapping("survey")
public class SurveyController {

    @Autowired
    private IQuesService                     quesService;

    @Autowired
    private IQuesTypeService                 quesTypeService;

    @Autowired
    private IQuesSurveyService               quesSurveyService;

    @Autowired
    private IQuesAnswerDetailService         quesAnswerDetailService;

    @Autowired
    private IQuesSurveyAnsweredDetailService quesSurveyAnsweredDetailService;

    @Autowired
    private IUserService                     userService;

    @ResponseBody
    @RequestMapping(value = "getName", method = RequestMethod.GET)
    public String getName(@RequestParam(value = "quesId", required = true) Long quesId) {
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

    @RequestMapping(value = "addQuesSurvey", method = RequestMethod.POST)
    @ResponseBody
    public RestResponseEntity addQuesSurvey(Model model, @RequestBody QuesSurvey quesSurvey) {

        //        QuesSurvey quesSurvey = new QuesSurvey();
        //        quesSurvey.setQuesSurveyLogoUrl(quesSurveyLogoUrl);
        //        quesSurvey.setQuesSurveyName(quesSurveyName);
        //        quesSurvey.setQuesSurveyRemarks(quesSurveyRemarks);
        //        quesSurvey.setQuesSurveyTitle(quesSurveyTitle);

        quesSurveyService.addQuesSurvey(quesSurvey);
        model.addAttribute("quesSurvey", "quesSurvey");

        return RestResponseEntity.getEntity(true);
    }

    @RequestMapping(value = "editQuesSurvey", method = RequestMethod.GET)
    public String editQuesSurvey(Model model, Long quesSurveyId) {

        QuesSurvey quesSurvey = new QuesSurvey();
        quesSurvey.setQuesSurveyId(quesSurveyId);
        //        QuesSurvey quesSurvey = new QuesSurvey();
        //        quesSurvey.setQuesSurveyLogoUrl(quesSurveyLogoUrl);
        //        quesSurvey.setQuesSurveyName(quesSurveyName);
        //        quesSurvey.setQuesSurveyRemarks(quesSurveyRemarks);
        //        quesSurvey.setQuesSurveyTitle(quesSurveyTitle);

        List<QuesSurvey> quesSurveyList = quesSurveyService.queyQuesSurveyByCondition(quesSurvey);
        model.addAttribute("quesSurvey", quesSurveyList.get(0));

        return "add-edit";
    }

    @RequestMapping(value = "getQuesTypeFtl", method = RequestMethod.GET)
    public String addQuesType(Model model, Long quesSurveyId) {
        QuesSurvey quesSurvey = new QuesSurvey();
        quesSurvey.setQuesSurveyId(quesSurveyId);
        List<QuesSurvey> surveyList = quesSurveyService.queyQuesSurveyByCondition(quesSurvey);
        model.addAttribute("survey", surveyList.get(0));
        return "questype-add";
    }

    /**
     * 添加题目大类
     *
     * @param quesType
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @ResponseBody
    @RequestMapping(value = "addQuesType", method = RequestMethod.POST)
    public RestResponseEntity addQuesType(@RequestBody QuesType quesType) {
        quesTypeService.addQuesType(quesType);
        return RestResponseEntity.getEntity(true);
    }

    @ResponseBody
    @RequestMapping(value = "addQues", method = RequestMethod.POST)
    public RestResponseEntity addQues(@RequestBody Ques ques) {
        quesService.addQues(ques);
        return RestResponseEntity.getEntity(true);
    }

    @RequestMapping(value = "addQuesAnswerDetail", method = RequestMethod.POST)
    @ResponseBody
    public RestResponseEntity addQuesAnswerDetail(@RequestBody QuesAnswerDetail quesAnswerDetail) {

        quesAnswerDetailService.addQuesAnswerDetail(quesAnswerDetail);
        return RestResponseEntity.getEntity(true);
    }

    @ResponseBody
    @RequestMapping(value = "queryQuesSurveyList", method = RequestMethod.GET)
    public ResultVO queryQuesSurveyList(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = true) int limit) {
        List<QuesSurvey> surveyList = quesSurveyService.queryQuesSurvey();
        //String jsons = JSON.toJSONString(surveyList);
        ResultVO vo = new ResultVO();
        vo.setCode("0");
        vo.setMsg("SUCCESS");
        vo.setCount(11); //TODO
        vo.setData(surveyList);
        return vo;
    }

    @ResponseBody
    @RequestMapping(value = "queryQuesTypeList", method = RequestMethod.GET)
    public ResultVO queryQuesTypeList(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = true) int limit) {
        List<QuesType> quesTypeList = quesTypeService.queryQuesTypeList(page, limit);
        //String jsons = JSON.toJSONString(surveyList);
        ResultVO vo = new ResultVO();
        vo.setCode("0");
        vo.setMsg("SUCCESS");
        vo.setCount(10); //TODO
        vo.setData(quesTypeList);
        return vo;
    }

    @RequestMapping(value = "getQuesFtl", method = RequestMethod.GET)
    public String addQuesType(Model model, Long quesSurveyId, Long quesTypeId) {
        Ques ques = new Ques();
        ques.setQuesSurveyId(quesSurveyId);
        ques.setQuesTypeId(quesTypeId);
        model.addAttribute("ques", ques);
        return "ques-add";
    }

    @ResponseBody
    @RequestMapping(value = "queryQuesList", method = RequestMethod.GET)
    public ResultVO queryQuesList(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = true) int limit) {
        List<Ques> quesList = quesService.queryQuesList(page, limit);
        ResultVO vo = new ResultVO();
        vo.setCode("0");
        vo.setMsg("SUCCESS");
        vo.setCount(10); //TODO
        vo.setData(quesList);
        return vo;
    }

    @RequestMapping(value = "getQuesAnswerFtl", method = RequestMethod.GET)
    public String getQuesAnswerFtl(Model model, Long quesId) {

        Ques ques = quesService.queryQuesById(quesId);
        model.addAttribute("ques", ques);
        return "quesanswer-add";
    }

    @ResponseBody
    @RequestMapping(value = "queryQuesAnswerList", method = RequestMethod.GET)
    public ResultVO queryQuesAnswerList(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = true) int limit) {
        List<QuesAnswerDetail> quesAnswerList = quesAnswerDetailService.queryQuesAnswerListPage(page, limit);
        ResultVO vo = new ResultVO();
        vo.setCode("0");
        vo.setMsg("SUCCESS");
        vo.setCount(quesAnswerDetailService.countQuesAnswer());
        vo.setData(quesAnswerList);
        return vo;
    }

    /**
     * 发布问卷调查
     * 
     * @param model
     * @param quesSurveyId
     * @param quesSurveyName
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "publishSurvey")
    public String publishSurvey(Model model, Long quesSurveyId, String quesSurveyName) {

        QuesSurveyVO resultVO = new QuesSurveyVO();

        QuesSurvey quesSurvey = new QuesSurvey();
        quesSurvey.setQuesSurveyId(quesSurveyId);
        List<QuesSurvey> queyQuesSurveyList = quesSurveyService.queyQuesSurveyByCondition(quesSurvey);
        resultVO.setQuesSurveyId(quesSurveyId);
        if (CollectionUtils.isNotEmpty(queyQuesSurveyList)) {
            quesSurveyName = queyQuesSurveyList.get(0).getQuesSurveyName();
        }
        resultVO.setQuesSurveyName(quesSurveyName);
        List<QuesType> queryQuesTypeList = quesTypeService.queryQuesTypeList(quesSurveyId);

        if (CollectionUtils.isNotEmpty(queryQuesTypeList)) {
            List<Long> quesTypeIds = Lists.newArrayList();
            for (QuesType quesType : queryQuesTypeList) {
                quesTypeIds.add(quesType.getQuesTypeId());
            }
            Map<Long, List<Ques>> queryQuesMap = quesService.queryQuesMap(quesSurveyId, quesTypeIds);
            List<Ques> queryQuesList = quesService.queryQues(quesSurveyId, quesTypeIds);

            Map<Long, List<QuesAnswerDetail>> quesAnswerDetailMap = Maps.newHashMap();
            if (CollectionUtils.isNotEmpty(queryQuesList)) {
                List<Long> quesIds = Lists.newArrayList();
                for (Ques ques : queryQuesList) {
                    quesIds.add(ques.getQuesId());
                }
                quesAnswerDetailMap = quesAnswerDetailService.queryQuesAnswerDetailMap(quesSurveyId, quesIds);
            }

            List<QuesTypeVO> quesTypeVOList = Lists.newArrayList();
            for (QuesType quesType : queryQuesTypeList) {
                QuesTypeVO typeVO = new QuesTypeVO();
                BeanUtils.copyProperties(quesType, typeVO);
                List<Ques> list = queryQuesMap.get(quesType.getQuesTypeId());

                List<QuesVO> quesVOList = Lists.newArrayList();
                if (CollectionUtils.isNotEmpty(list)) {
                    for (Ques ques : list) {
                        QuesVO quesVO = new QuesVO();
                        BeanUtils.copyProperties(ques, quesVO);
                        List<QuesAnswerDetail> asrList = quesAnswerDetailMap.get(quesVO.getQuesId());

                        quesVO.setQuesAnswerDetailList(asrList);
                        quesVOList.add(quesVO);
                    }

                    typeVO.setQuesList(quesVOList);
                    quesTypeVOList.add(typeVO);
                }
            }

            resultVO.setQuesTypeList(quesTypeVOList);

        }
        model.addAttribute("survey", resultVO);

        return "publish_survey";
    }

    /**
     * 发布问卷调查
     * 
     * @param model
     * @param quesSurveyId
     * @param quesSurveyName
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "publish")
    @ResponseBody
    public RestResponseEntity publish(Model model, @RequestBody QuesSurveyAnsweredDetail[] ansDetailList) {

        List<QuesSurveyAnsweredDetail> detailList = Arrays.asList(ansDetailList);
        quesSurveyAnsweredDetailService.batchInsert(detailList);
        return RestResponseEntity.getEntity(true);
    }
};
