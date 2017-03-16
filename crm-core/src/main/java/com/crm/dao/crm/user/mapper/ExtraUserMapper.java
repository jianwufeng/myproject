package com.crm.dao.crm.user.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.crm.domain.crm.User;

/**
 * Date: 2017年1月20日 下午2:16:26
 * 
 * @author Jihan
 */
public interface ExtraUserMapper {

    public List<User> selectByCondition(RowBounds rowBounds);

}
