package com.crm.survey.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.crm.dto.SurveyCompanyPerDto;
import com.crm.dto.Top5Dto;
import com.crm.survey.controller.dto.DataMapDto;
import com.crm.survey.controller.dto.ExportExcelDto;
import com.crm.survey.controller.dto.FormData;
import com.crm.survey.controller.dto.QuesDto;
import com.crm.survey.controller.dto.QuesSurveyDto;
import com.crm.util.date.DateUtils;
import com.crm.util.excel.ExcelUtils;
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

    @RequestMapping(value = "index.ftl", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "updatePwdFtl.ftl", method = RequestMethod.GET)
    public String updatePwdFtl(Model model, String userName) {
        model.addAttribute("userName", userName);
        return "update-pwd";
    }

    @ResponseBody
    @RequestMapping(value = "updatePwd.ftl", method = RequestMethod.POST)
    public RestResponseEntity updatePwd(@RequestBody User user) {
        userService.updateUserByCondition(user);
        return RestResponseEntity.getEntity(true);
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public RestResponseEntity login(HttpServletRequest request, Model model, @RequestBody User user) {
        HttpSession session = request.getSession();
        List<User> userList = userService.getUserByCondition(user);
        if (CollectionUtils.isNotEmpty(userList)) {
            if (!user.getPassword().equals(userList.get(0).getPassword())) {
                return RestResponseEntity.getEntity(false);
            } else {
                session.setAttribute("loginUser", userList.get(0));
                model.addAttribute("loginUser", userList.get(0));
                return RestResponseEntity.getEntity(true);

            }
        } else {
            return RestResponseEntity.getEntity(false);
        }

    }

    @ResponseBody
    @RequestMapping(value = "logout.ftl", method = RequestMethod.POST)
    public RestResponseEntity logout(HttpServletRequest request, Model model) {
        request.getSession().invalidate();
        return RestResponseEntity.getEntity(true);
    }

    /*
     * @RequestMapping(value = "index", method = RequestMethod.GET) public
     * String indexFtl() { return "index"; }
     */

    @RequestMapping(value = "saveQuesSurvey.ftl", method = RequestMethod.POST)
    @ResponseBody
    public RestResponseEntity addQuesSurvey(Model model, @RequestBody QuesSurveyDto quesSurvey) {

        //        QuesSurvey quesSurvey = new QuesSurvey();
        //        quesSurvey.setQuesSurveyLogoUrl(quesSurveyLogoUrl);
        //        quesSurvey.setQuesSurveyName(quesSurveyName);
        //        quesSurvey.setQuesSurveyRemarks(quesSurveyRemarks);
        //        quesSurvey.setQuesSurveyTitle(quesSurveyTitle);

        if (quesSurvey.getQuesSurveyId() == null) {
            quesSurveyService.addQuesSurvey(quesSurvey);
        } else {
            quesSurveyService.updateByCondition(quesSurvey);
        }
        model.addAttribute("quesSurvey", "quesSurvey");

        return RestResponseEntity.getEntity(true);
    }

    @RequestMapping(value = "getQuesSurvey.ftl", method = RequestMethod.GET)
    public String getQuesSurvey(Model model, Long quesSurveyId) {
        QuesSurvey survey = new QuesSurvey();
        if (quesSurveyId != null) {
            QuesSurvey quesSurvey = new QuesSurvey();
            quesSurvey.setQuesSurveyId(quesSurveyId);

            List<QuesSurvey> quesSurveyList = quesSurveyService.queyQuesSurveyByCondition(quesSurvey);
            survey = quesSurveyList.get(0);
        }
        model.addAttribute("quesSurvey", survey);

        return "add-edit-ques-survey";
    }

    @RequestMapping(value = "getQuesTypeFtl.ftl", method = RequestMethod.GET)
    public String getQuesTypeFtl(Model model, Long quesSurveyId, Long quesTypeId) {
        QuesSurvey quesSurvey = new QuesSurvey();
        quesSurvey.setQuesSurveyId(quesSurveyId);
        List<QuesSurvey> surveyList = quesSurveyService.queyQuesSurveyByCondition(quesSurvey);

        QuesType quesType = new QuesType();
        if (quesTypeId != null) {
            quesType = quesTypeService.getById(quesTypeId);
        }

        model.addAttribute("survey", surveyList.get(0));
        model.addAttribute("quesType", quesType);
        return "questype-add";
    }

    @ResponseBody
    @RequestMapping(value = "deleteQuesType.ftl", method = RequestMethod.POST)
    public RestResponseEntity deleteQuesType(Model model, Long quesTypeId) {
        QuesType quesType = new QuesType();
        quesType.setQuesTypeId(quesTypeId);
        quesType.setIsDelete(true);
        quesTypeService.updateQuesType(quesType);
        return RestResponseEntity.getEntity(true);
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
    @RequestMapping(value = "saveQuesType.ftl", method = RequestMethod.POST)
    public RestResponseEntity saveQuesType(@RequestBody FormData formData) {
        String flag = "add";
        if (formData.getQuesType().getQuesTypeId() != null) {
            quesTypeService.updateQuesType(formData.getQuesType());
            flag = "update";
        } else {
            quesTypeService.addQuesType(formData.getQuesType());
        }
        return RestResponseEntity.getEntity(true, "0", "SUCCESS", flag);
    }

    @ResponseBody
    @RequestMapping(value = "addQues", method = RequestMethod.POST)
    public RestResponseEntity addQues(@RequestBody FormData formData) {
        Long quesId = quesService.addQues(formData.getQues());
        List<QuesAnswerDetail> quesAnswerDetailList = formData.getQuesAnswerDetailList();
        if (CollectionUtils.isNotEmpty(quesAnswerDetailList)) {
            for (QuesAnswerDetail quesAnswerDetail : quesAnswerDetailList) {
                Ques queryQues = quesService.queryQuesById(quesId);
                if (queryQues != null) {
                    quesAnswerDetail.setQuesId(quesId);
                    quesAnswerDetail.setQuesName(queryQues.getQuesName());
                    quesAnswerDetail.setQuesSurveyId(queryQues.getQuesSurveyId());
                    quesAnswerDetail.setQuesTypeId(queryQues.getQuesTypeId());
                }
                quesAnswerDetailService.addQuesAnswerDetail(quesAnswerDetail);
            }
        }
        return RestResponseEntity.getEntity(true);
    }

    @ResponseBody
    @RequestMapping(value = "editQues.ftl", method = RequestMethod.POST)
    public RestResponseEntity editQues(@RequestBody FormData formData) {
        quesService.editQues(formData.getQues());
        List<QuesAnswerDetail> quesAnswerDetailList = formData.getQuesAnswerDetailList();
        if (CollectionUtils.isNotEmpty(quesAnswerDetailList)) {
            for (QuesAnswerDetail quesAnswerDetail : quesAnswerDetailList) {
                Ques queryQues = quesService.queryQuesById(formData.getQues().getQuesId());
                if (queryQues != null) {
                    quesAnswerDetail.setQuesId(formData.getQues().getQuesId());
                    quesAnswerDetail.setQuesName(queryQues.getQuesName());
                    quesAnswerDetail.setQuesSurveyId(queryQues.getQuesSurveyId());
                    quesAnswerDetail.setQuesTypeId(queryQues.getQuesTypeId());
                }

                if (quesAnswerDetailService.updateQuesAnswerDetail(quesAnswerDetail) <= 0) {
                    quesAnswerDetailService.addQuesAnswerDetail(quesAnswerDetail);
                }
            }
        }
        return RestResponseEntity.getEntity(true);
    }

    @RequestMapping(value = "getQues.ftl", method = RequestMethod.GET)
    public String getQuesFtl(Model model, Long quesSurveyId, Long quesId) {
        Ques ques = quesService.queryQuesById(quesId);
        List<Long> quesIdList = Lists.newArrayList();
        quesIdList.add(quesId);
        List<QuesAnswerDetail> answerDetailList = quesAnswerDetailService.queryQuesAnswerDetailList(quesSurveyId, quesIdList);
        model.addAttribute("ques", ques);
        model.addAttribute("answerDetailList", answerDetailList);
        return "ques-edit";
    }

    @RequestMapping(value = "addQuesAnswerDetail", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public RestResponseEntity addQuesAnswerDetail(@RequestBody QuesAnswerDetail quesAnswerDetail) {

        quesAnswerDetailService.addQuesAnswerDetail(quesAnswerDetail);
        return RestResponseEntity.getEntity(true);
    }

    @ResponseBody
    @RequestMapping(value = "queryQuesSurveyList", method = RequestMethod.GET)
    public ResultVO queryQuesSurveyList(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = true) int limit) {
        List<QuesSurvey> surveyList = quesSurveyService.queryQuesSurvey(page, limit);
        //String jsons = JSON.toJSONString(surveyList);
        ResultVO vo = new ResultVO();
        vo.setCode("0");
        vo.setMsg("SUCCESS");
        vo.setCount(quesSurveyService.countQuesSurvey());
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
        vo.setCount(quesTypeService.countQuesType());
        vo.setData(quesTypeList);
        return vo;
    }

    /**
     * 大类添加题目
     *
     * @param model
     * @param quesSurveyId
     * @param quesTypeId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "getQuesFtl", method = RequestMethod.GET)
    public String addQuesType(Model model, Long quesSurveyId, Long quesTypeId) {
        Ques ques = new Ques();
        ques.setQuesSurveyId(quesSurveyId);
        ques.setQuesTypeId(quesTypeId);

        QuesType quesType = quesTypeService.getById(quesTypeId);
        List<Ques> quesList = quesService.queryQuesListBy(quesTypeId);

        List<QuesDto> quesDtoList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(quesList)) {
            List<Long> quesIds = Lists.newArrayList();
            for (Ques q : quesList) {
                quesIds.add(q.getQuesId());
            }
            Map<Long, List<QuesAnswerDetail>> quesAnswerDetailMap = quesAnswerDetailService.queryQuesAnswerDetailMap(quesSurveyId, quesIds);

            for (Ques q : quesList) {
                QuesDto dto = new QuesDto();
                dto.setQues(q);
                dto.setQuesAnswerDetailList(quesAnswerDetailMap.get(q.getQuesId()));
                quesDtoList.add(dto);
            }

        }

        model.addAttribute("ques", ques);
        model.addAttribute("quesType", quesType);
        model.addAttribute("quesDtoList", quesDtoList);
        return "ques-add";
    }

    @ResponseBody
    @RequestMapping(value = "queryQuesList", method = RequestMethod.GET)
    public ResultVO queryQuesList(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = true) int limit) {
        List<Ques> quesList = quesService.queryQuesList(page, limit);
        ResultVO vo = new ResultVO();
        vo.setCode("0");
        vo.setMsg("SUCCESS");
        vo.setCount(quesService.countQues());
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
            QuesSurvey quesSurvey2 = queyQuesSurveyList.get(0);
            if (quesSurvey2 != null) {
                quesSurveyName = quesSurvey2.getQuesSurveyName();
                String quesSurveyRemarks = quesSurvey2.getQuesSurveyRemarks();
                resultVO.setQuesSurveyRemarks(quesSurveyRemarks);
                resultVO.setStartDate(quesSurvey2.getStartDate());
                resultVO.setEndDate(quesSurvey2.getEndDate());
                resultVO.setQuesSurveyLogoUrl(quesSurvey2.getQuesSurveyLogoUrl());
            }
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
     * @throws ParseException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "publish")
    @ResponseBody
    public RestResponseEntity publish(Model model, @RequestBody QuesSurveyAnsweredDetail[] ansDetailList) throws ParseException {
        List<QuesSurveyAnsweredDetail> detailList = Arrays.asList(ansDetailList);
        QuesSurvey survey = quesSurveyService.getQuesSurveyById(detailList.get(0).getQuesSurveyId());
        if (survey != null) {
            String startDate = survey.getStartDate();
            String endDate = survey.getEndDate();
            Date sDate = DateUtils.getStartTimeOfDay(DateUtils.parseDate(startDate, "yyyy-MM-dd"));
            Date eDate = DateUtils.getEndTimeOfDay(DateUtils.parseDate(endDate, "yyyy-MM-dd"));
            Date now = new Date();
            if (now.before(sDate) || now.after(eDate)) {
                return RestResponseEntity.getEntity(false, "1001", "很抱歉，已超出问卷截止时间", false);
            }
        }
        List<QuesType> queryQuesTypeList = quesTypeService.queryQuesTypeList(detailList.get(0).getQuesSurveyId());
        Map<Long, Integer> map = Maps.newHashMap();
        if (CollectionUtils.isNotEmpty(queryQuesTypeList)) {
            for (QuesType quesType : queryQuesTypeList) {
                map.put(quesType.getQuesTypeId(), quesType.getIsBackgroundSurvey());
            }
        }

        for (QuesSurveyAnsweredDetail detail : detailList) {
            detail.setIsBackgroundSurvey(map.get(detail.getQuesTypeId()));
        }
        quesSurveyAnsweredDetailService.batchInsert(detailList);
        return RestResponseEntity.getEntity(true);
    }

    @ResponseBody
    @RequestMapping(value = "deleteSurvey.ftl")
    public RestResponseEntity deleteSurvey(Model model, Long quesSurveyId) throws ParseException {
        QuesSurvey quesSurvey = new QuesSurvey();
        quesSurvey.setQuesSurveyId(quesSurveyId);
        quesSurvey.setIsDelete(true);
        quesSurveyService.updateByCondition(quesSurvey);
        return RestResponseEntity.getEntity(true);
    }

    @ResponseBody
    @RequestMapping(value = "deleteQues.ftl")
    public RestResponseEntity deleteQues(Model model, Long quesId) throws ParseException {
        Ques ques = new Ques();
        ques.setQuesId(quesId);
        ques.setIsDelete(true);
        quesService.editQues(ques);
        return RestResponseEntity.getEntity(true);
    }

    @ResponseBody
    @RequestMapping(value = "exportExcel.ftl", method = { RequestMethod.POST, RequestMethod.GET })
    public RestResponseEntity exportExcel(@RequestParam(value = "quesSurveyId", required = true) Long quesSurveyId, HttpServletRequest request, HttpServletResponse response)
            throws IllegalArgumentException, IllegalAccessException {
        String[] arr = { "", "非常同意", "同意", "部分同意", "不同意", "非常不同意" };

        List<ExportExcelDto> list = Lists.newArrayList();

        Map<Long, Top5Dto> veryAgreeMap = quesSurveyAnsweredDetailService.getPerListByAnswer(quesSurveyId, "非常同意%");
        Map<Long, Top5Dto> agreeMap = quesSurveyAnsweredDetailService.getPerListByAnswer(quesSurveyId, "同意%");
        Map<Long, Top5Dto> partAgreeMap = quesSurveyAnsweredDetailService.getPerListByAnswer(quesSurveyId, "部分同意%");
        Map<Long, Top5Dto> disAgreeMap = quesSurveyAnsweredDetailService.getPerListByAnswer(quesSurveyId, "不同意%");
        Map<Long, Top5Dto> veryDisAgreeMap = quesSurveyAnsweredDetailService.getPerListByAnswer(quesSurveyId, "非常不同意%");
        SurveyCompanyPerDto perDto = quesSurveyAnsweredDetailService.getPerListByCompany(quesSurveyId);
        ExportExcelDto dto1 = new ExportExcelDto();
        dto1.setQuesTypeName(perDto.getCompanyName());
        dto1.setVeryAgreePer(perDto.getVeryAgreePer() + "%");
        dto1.setAgreePer(perDto.getAgreePer() + "%");
        dto1.setDisAgreePer(perDto.getDisagreePer() + "%");
        dto1.setVeryDisAgreePer(perDto.getVeryDisagreePer() + "%");
        dto1.setPartAgreePer(perDto.getPartAgreePer() + "%");
        list.add(dto1);

        QuesType req = new QuesType();
        req.setQuesSurveyId(quesSurveyId);
        List<QuesType> quesTypeList = quesTypeService.queryQuesTypeList(req);
        if (CollectionUtils.isNotEmpty(quesTypeList)) {
            for (QuesType quesType : quesTypeList) {
                ExportExcelDto dto = new ExportExcelDto();
                dto.setQuesTypeName(quesType.getQuesTypeName());
                dto.setVeryAgreePer(veryAgreeMap.get(quesType.getQuesTypeId()) == null ? "0.00%" : veryAgreeMap.get(quesType.getQuesTypeId()).getTopPer() + "%");
                dto.setAgreePer(agreeMap.get(quesType.getQuesTypeId()) == null ? "0.00%" : agreeMap.get(quesType.getQuesTypeId()).getTopPer() + "%");
                dto.setDisAgreePer(disAgreeMap.get(quesType.getQuesTypeId()) == null ? "0.00%" : disAgreeMap.get(quesType.getQuesTypeId()).getTopPer() + "%");
                dto.setVeryDisAgreePer(veryDisAgreeMap.get(quesType.getQuesTypeId()) == null ? "0.00%" : veryDisAgreeMap.get(quesType.getQuesTypeId()).getTopPer() + "%");
                dto.setPartAgreePer(partAgreeMap.get(quesType.getQuesTypeId()) == null ? "0.00%" : partAgreeMap.get(quesType.getQuesTypeId()).getTopPer() + "%");
                list.add(dto);
            }
        }

        ExcelUtils.export(response, arr, list, ExportExcelDto.class);

        return RestResponseEntity.getEntity(true);
    }

    @RequestMapping(value = "getDataMapFtl.ftl", method = { RequestMethod.POST, RequestMethod.GET })
    public String getDataMapFtl(Model model, @RequestParam(value = "quesSurveyId", required = true) Long quesSurveyId) {
        model.addAttribute("quesSurveyId", quesSurveyId);
        return "map";
    }

    @ResponseBody
    @RequestMapping(value = "getDataMap.ftl", method = { RequestMethod.POST, RequestMethod.GET })
    public RestResponseEntity getDataMap(HttpServletRequest request, HttpServletResponse response, Long quesSurveyId) {
        DataMapDto dto = new DataMapDto();
        List<String> quesTypeNameAgreeList = Lists.newArrayList();
        List<String> quesTypePerAgreeList = Lists.newArrayList();
        List<String> quesTypeNameDisAgreeList = Lists.newArrayList();
        List<String> quesTypePerDisAgreeList = Lists.newArrayList();

        List<Top5Dto> agreeTop5List = quesSurveyAnsweredDetailService.getAgreeTop5(quesSurveyId);
        List<QuesType> quesTypeList = quesTypeService.queryQuesTypeList(quesSurveyId);
        Map<Long, QuesType> map = Maps.newHashMap();
        for (QuesType quesType : quesTypeList) {
            map.put(quesType.getQuesTypeId(), quesType);
        }
        if (CollectionUtils.isNotEmpty(agreeTop5List)) {
            for (Top5Dto top5Dto : agreeTop5List) {
                quesTypeNameAgreeList.add(map.get(top5Dto.getQuesTypeId()).getQuesTypeName());
                quesTypePerAgreeList.add(top5Dto.getTopPer());
            }

        }
        List<Top5Dto> disAgreeTop5List = quesSurveyAnsweredDetailService.getDisAgreeTop5(quesSurveyId);
        if (CollectionUtils.isNotEmpty(disAgreeTop5List)) {
            for (Top5Dto top5Dto : disAgreeTop5List) {
                quesTypeNameDisAgreeList.add(map.get(top5Dto.getQuesTypeId()).getQuesTypeName());
                quesTypePerDisAgreeList.add(top5Dto.getTopPer());
            }
        }
        dto.setQuesTypeNameAgreeList(quesTypeNameAgreeList);
        dto.setQuesTypePerAgreeList(quesTypePerAgreeList);
        dto.setQuesTypeNameDisAgreeList(quesTypeNameDisAgreeList);
        dto.setQuesTypePerDisAgreeList(quesTypePerDisAgreeList);
        return RestResponseEntity.getEntity(dto);
    }

};
