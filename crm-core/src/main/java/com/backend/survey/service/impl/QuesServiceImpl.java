package com.backend.survey.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesMapper;
import com.backend.survey.service.IQuesService;
import com.crm.domain.backend.survey.Ques;
import com.crm.domain.backend.survey.QuesExample;
import com.crm.domain.backend.survey.QuesExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service("quesService")
public class QuesServiceImpl implements IQuesService {
    @Autowired
    private QuesMapper quesMapper;

    @Override
    public List<Ques> getQuesByQuesId(Long quesId) {
        QuesExample example = new QuesExample();
        example.createCriteria().andQuesIdEqualTo(quesId);
        return quesMapper.selectByExample(example);
    }

    @Override
    public Long addQues(Ques ques) {
        ques.setCreateTime(new Date());
        ques.setUpdateTime(ques.getCreateTime());
        quesMapper.insertSelective(ques);
        return ques.getQuesId();
    }

    @Override
    public List<Ques> queryQues(Long quesSurveyId, List<Long> quesTypeIds) {
        QuesExample example = new QuesExample();
        example.createCriteria().andQuesSurveyIdEqualTo(quesSurveyId).andQuesTypeIdIn(quesTypeIds);
        return quesMapper.selectByExample(example);
    }

    @Override
    public Map<Long, List<Ques>> queryQuesMap(Long quesSurveyId, List<Long> quesTypeIds) {
        Map<Long, List<Ques>> resultMap = Maps.newHashMap();
        List<Ques> list = queryQues(quesSurveyId, quesTypeIds);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Ques ques : list) {
                if (CollectionUtils.isEmpty(resultMap.get(ques.getQuesTypeId()))) {
                    List<Ques> quesList = Lists.newArrayList();
                    quesList.add(ques);
                    resultMap.put(ques.getQuesTypeId(), quesList);
                } else {
                    List<Ques> existList = resultMap.get(ques.getQuesTypeId());
                    existList.add(ques);
                }
            }
        }
        return resultMap;
    }

    @Override
    public Ques queryQuesById(Long quesId) {
        return quesMapper.selectByPrimaryKey(quesId);
    }

    @Override
    public List<Ques> queryQuesList(int page, int limit) {
        QuesExample example = new QuesExample();
        PageHelper.startPage(page, limit, false);
        example.setOrderByClause("ques_id desc");
        //example.setLimit(new Limit((page - 1) * limit, limit));
        Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(false);
        return quesMapper.selectByExample(example);
    }

    @Override
    public List<Ques> queryQuesListBy(Long quesTypeId) {
        QuesExample example = new QuesExample();
        Criteria criteria = example.createCriteria();
        criteria.andQuesTypeIdEqualTo(quesTypeId).andIsDeleteEqualTo(false);
        return quesMapper.selectByExample(example);
    }

    @Override
    public List<Ques> queryQuesListByIds(List<Long> quesIds) {
        QuesExample example = new QuesExample();
        Criteria criteria = example.createCriteria();
        criteria.andQuesIdIn(quesIds).andIsDeleteEqualTo(false);
        return quesMapper.selectByExample(example);
    }

    @Override
    public int countQues() {
        QuesExample example = new QuesExample();
        return quesMapper.countByExample(example);
    }

    @Override
    public void editQues(Ques ques) {
        ques.setUpdateTime(new Date());
        quesMapper.updateByPrimaryKeySelective(ques);
    }

}
