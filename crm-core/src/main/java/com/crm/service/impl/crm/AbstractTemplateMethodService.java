package com.crm.service.impl.crm;

import com.crm.domain.crm.User;
import com.crm.service.TemplateMethodService;

/**
 * Date: 2017年1月11日 上午10:59:50
 * 
 * @author Jihan
 */
public abstract class AbstractTemplateMethodService implements TemplateMethodService {

    // 模板方法
    public void submit(User user) {
        // TODO
    }

    public abstract void save(); // 由各子类各自实现
}
