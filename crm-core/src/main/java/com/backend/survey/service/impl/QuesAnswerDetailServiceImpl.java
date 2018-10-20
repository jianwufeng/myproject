package com.backend.survey.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.survey.mapper.QuesAnswerDetailMapper;
import com.backend.survey.service.IQuesAnswerDetailService;
import com.crm.domain.backend.survey.QuesAnswerDetail;
import com.crm.domain.backend.survey.QuesAnswerDetailExample;
import com.crm.util.mybatis.plugin.Limit;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service("quesAnswerDetailService")
public class QuesAnswerDetailServiceImpl implements IQuesAnswerDetailService {

    @Autowired
    private QuesAnswerDetailMapper quesAnswerDetailMapper;

    @Override
    public void addQuesAnswerDetail(QuesAnswerDetail aser) {
        quesAnswerDetailMapper.insertSelective(aser);
    }

    @Override
    public List<QuesAnswerDetail> queryQuesAnswerDetailList(Long quesSurveyId, List<Long> quesIds) {

        QuesAnswerDetailExample example = new QuesAnswerDetailExample();
        example.createCriteria().andQuesSurveyIdEqualTo(quesSurveyId).andQuesIdIn(quesIds);
        return quesAnswerDetailMapper.selectByExample(example);
    }

    @Override
    public Map<Long, List<QuesAnswerDetail>> queryQuesAnswerDetailMap(Long querySurveyId, List<Long> quesIds) {
        Map<Long, List<QuesAnswerDetail>> resultMap = Maps.newHashMap();
        List<QuesAnswerDetail> quesAnswerDetailList = queryQuesAnswerDetailList(querySurveyId, quesIds);
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
        example.setLimit(new Limit((page - 1) * limit, limit));
        return quesAnswerDetailMapper.selectByExample(example);
    }

    @Override
    public int countQuesAnswer() {
        QuesAnswerDetailExample example = new QuesAnswerDetailExample();
        return quesAnswerDetailMapper.countByExample(example);
    }
}
