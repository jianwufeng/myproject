package com.crm.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.crm.domain.CityDO;
import com.crm.exception.ServiceException;
import com.crm.service.CityService;
import com.crm.util.Page;

@Service(value = "cityService")
public class CityServiceImpl implements CityService {

    private Log logger = LogFactory.getLog(this.getClass());

    public Page<CityDO> queryPageListByCityDOAndStartPageSize(CityDO cityDO, int startPage, int pageSize) {
        if (cityDO != null && startPage > 0 && pageSize > 0) {
            cityDO.setStartPage(startPage);
            cityDO.setPageSize(pageSize);
            return this.queryPageListByCityDO(cityDO);
        }
        return new Page<CityDO>();
    }

    @Override
    public Long insert(CityDO cityDO) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(CityDO cityDO, boolean isAllField) throws ServiceException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteById(Long id) throws ServiceException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public CityDO selectById(Long id) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long selectCountDynamic(CityDO cityDO) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CityDO> selectDynamic(CityDO cityDO) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<CityDO> queryPageListByCityDO(CityDO cityDO) {
        // TODO Auto-generated method stub
        return null;
    }

}
