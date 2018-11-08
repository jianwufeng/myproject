package com.backend.survey.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesAnswerDetailMapper;
import com.backend.survey.service.IQuesAnswerDetailService;
import com.backend.survey.service.IQuesService;
import com.crm.domain.backend.survey.Ques;
import com.crm.domain.backend.survey.QuesAnswerDetail;
import com.crm.domain.backend.survey.QuesAnswerDetailExample;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service("quesAnswerDetailService")
public class QuesAnswerDetailServiceImpl implements IQuesAnswerDetailService {

    @Autowired
    private QuesAnswerDetailMapper quesAnswerDetailMapper;

    @Autowired
    private IQuesService           quesService;

    @Override
    public void addQuesAnswerDetail(QuesAnswerDetail aser) {
        aser.setCreateTime(new Date());
        aser.setUpdateTime(aser.getCreateTime());
        quesAnswerDetailMapper.insertSelective(aser);
    }

    @Override
    public List<QuesAnswerDetail> queryQuesAnswerDetailList(Long quesSurveyId, List<Long> quesIds) {

        QuesAnswerDetailExample example = new QuesAnswerDetailExample();
        example.createCriteria().andQuesSurveyIdEqualTo(quesSurveyId).andQuesIdIn(quesIds);
        return quesAnswerDetailMapper.selectByExample(example);
    }

    @Override
    public Map<Long, List<QuesAnswerDetail>> queryQuesAnswerDetailMap(Long quesSurveyId, List<Long> quesIds) {
        Map<Long, List<QuesAnswerDetail>> resultMap = Maps.newHashMap();
        List<QuesAnswerDetail> quesAnswerDetailList = queryQuesAnswerDetailList(quesSurveyId, quesIds);
        if (CollectionUtils.isNotEmpty(quesAnswerDetailList)) {
            for (QuesAnswerDetail quesAnswerDetail : quesAnswerDetailList) {
                if (CollectionUtils.isEmpty(resultMap.get(quesAnswerDetail.getQuesId()))) {
                    List<QuesAnswerDetail> aswerList = Lists.newArrayList();
                    aswerList.add(quesAnswerDetail);
                    resultMap.put(quesAnswerDetail.getQuesId(), aswerList);
                } else {
                    List<QuesAnswerDetail> list = resultMap.get(quesAnswerDetail.getQuesId());
                    list.add(quesAnswerDetail);
                }
            }
        }
        return resultMap;
    }

    @Override
    public List<QuesAnswerDetail> queryQuesAnswerListPage(int page, int limit) {
        QuesAnswerDetailExample example = new QuesAnswerDetailExample();
        example.setOrderByClause("answer_id desc");
        //example.setLimit(new Limit((page - 1) * limit, limit));
        PageHelper.startPage(page, limit, false);
        return quesAnswerDetailMapper.selectByExample(example);
    }

    @Override
    public int countQuesAnswer() {
        QuesAnswerDetailExample example = new QuesAnswerDetailExample();
        return quesAnswerDetailMapper.countByExample(example);
    }

    @Override
    public Map<Ques, List<QuesAnswerDetail>> queryQuesAnswerDetailMapBy(Long quesSurveyId, List<Long> quesIds) {
        Map<Ques, List<QuesAnswerDetail>> resultMap = Maps.newHashMap();
        List<QuesAnswerDetail> quesAnswerDetailList = queryQuesAnswerDetailList(quesSurveyId, quesIds);

        Map<Long, Ques> quesMap = Maps.newHashMap();
        List<Ques> quesList = quesService.queryQuesListByIds(quesIds);
        if (CollectionUtils.isNotEmpty(quesList)) {
            for (Ques ques : quesList) {
                quesMap.put(ques.getQuesId(), ques);
            }
        }

        if (CollectionUtils.isNotEmpty(quesAnswerDetailList)) {
            for (QuesAnswerDetail quesAnswerDetail : quesAnswerDetailList) {
                if (CollectionUtils.isEmpty(resultMap.get(quesAnswerDetail.getQuesId()))) {
                    List<QuesAnswerDetail> aswerList = Lists.newArrayList();
                    aswerList.add(quesAnswerDetail);
                    resultMap.put(quesMap.get(quesAnswerDetail.getQuesId()), aswerList);
                } else {
                    List<QuesAnswerDetail> list = resultMap.get(quesAnswerDetail.getQuesId());
                    list.add(quesAnswerDetail);
                }
            }
        }
        return resultMap;
    }

    @Override
    public int updateQuesAnswerDetail(QuesAnswerDetail quesAnswerDetail) {
        quesAnswerDetail.setUpdateTime(new Date());
        return quesAnswerDetailMapper.updateByPrimaryKeySelective(quesAnswerDetail);
    }
}
