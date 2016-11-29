package com.crm.service;

import java.util.List;

import com.crm.domain.CityDO;
import com.crm.exception.ServiceException;
import com.crm.util.Page;

/**
 * Service
 * 
 * @author haisheng.long 2016-06-02 10:49:37
 */
public interface CityService {

    /**
     * 插入
     * 
     * @param cityDO
     * @return 主键
     * @throws ServiceException
     * @author longhaisheng 2016-06-02 10:49:37
     */
    Long insert(CityDO cityDO) throws ServiceException;

    /**
     * 根据CityDO对象更新
     * 
     * @param cityDO
     * @param isAllField 是否更新所有字段(false 动态更新字段，true 更新所有字段,传null或false将动态更新，建议动态更新)
     * @return 更新行数
     * @throws ServiceException
     * @author longhaisheng 2016-06-02 10:49:37
     */
    int update(CityDO cityDO, boolean isAllField) throws ServiceException;

    // /**
    // * 根据ID更新 全部字段
    // * @param cityDO
    // * @return 更新行数
    // * @throws ServiceException
    // * @author longhaisheng 2016-06-02 10:49:37
    // */
    // int updateById(CityDO cityDO) throws ServiceException;

    /**
     * 根据ID删除
     * 
     * @param id
     * @return 物理删除行
     * @throws ServiceException
     * @author longhaisheng 2016-06-02 10:49:37
     */
    int deleteById(Long id) throws ServiceException;

    // /**
    // * 动态更新 部分字段
    // * @param cityDO
    // * @return 更新行数
    // * @throws ServiceException
    // * @author longhaisheng 2016-06-02 10:49:37
    // */
    // int updateDynamic(CityDO cityDO) throws ServiceException;

    /**
     * 根据ID查询 一个
     * 
     * @param id
     * @return CityDO
     * @throws ServiceException
     * @author longhaisheng 2016-06-02 10:49:37
     */
    CityDO selectById(Long id) throws ServiceException;

    /**
     * 根据 动态返回记录数
     * 
     * @param cityDO
     * @return 记录数
     * @throws ServiceException
     * @author longhaisheng 2016-06-02 10:49:37
     */
    Long selectCountDynamic(CityDO cityDO) throws ServiceException;

    /**
     * 动态返回 列表
     * 
     * @param cityDO
     * @return List<CityDO>
     * @throws ServiceException
     * @author longhaisheng 2016-06-02 10:49:37
     */
    List<CityDO> selectDynamic(CityDO cityDO) throws ServiceException;

    /**
     * 动态返回 分页列表
     * 
     * @param cityDO
     * @return Page<CityDO>
     * @throws ServiceException
     * @author longhaisheng 2016-06-02 10:49:37
     */
    Page<CityDO> queryPageListByCityDO(CityDO cityDO);

    /**
     * 动态返回 分页列表
     * 
     * @param cityDO
     * @param startPage 起始页
     * @param pageSize 每页记录数
     * @return Page<CityDO>
     * @throws ServiceException
     * @author longhaisheng 2016-06-02 10:49:37
     */
    Page<CityDO> queryPageListByCityDOAndStartPageSize(CityDO cityDO, int startPage, int pageSize);

}
