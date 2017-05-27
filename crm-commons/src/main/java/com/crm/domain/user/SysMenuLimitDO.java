package com.crm.domain.user;

import org.apache.commons.lang3.StringUtils;

import com.crm.domain.BaseDO;

/**
 * 权限
 * 
 * @author haisheng.long Tue Dec 30 19:15:56 CST 2014
 */

public class SysMenuLimitDO extends BaseDO {

    /**
     * <pre>
     * 
     * </pre>
     */
    private static final long serialVersionUID = -5401391277057970514L;

    /** 主键 */
    private Long id;

    /** 菜单id */
    private Long sysMenuId;

    /** 权限描述 */
    private String permission;

    /** 状态 */
    private Boolean state;

    public SysMenuLimitDO() {
    }

    public SysMenuLimitDO(Long sysMenuId, String permission, Boolean state) {
        this.sysMenuId = sysMenuId;
        this.permission = permission;
        this.state = state;
    }

    /**
     * 设置 主键
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置 菜单id
     * 
     * @param sysMenuId
     */
    public void setSysMenuId(Long sysMenuId) {
        this.sysMenuId = sysMenuId;
    }

    /**
     * 设置 权限描述
     * 
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
        if (StringUtils.isNotEmpty(this.permission)) {
            if (this.permission.endsWith(":view")) {
                this.setDesc("浏览");
            } else if (this.permission.endsWith(":create")) {
                this.setDesc("创建");
            } else if (this.permission.endsWith(":update")) {
                this.setDesc("维护");
            } else if (this.permission.endsWith(":delete")) {
                this.setDesc("删除");
            } else {
                this.setDesc("全部");
            }
        }

    }

    /**
     * 设置 状态
     * 
     * @param state
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取 主键
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 获取 菜单id
     * 
     * @return sysMenuId
     */
    public Long getSysMenuId() {
        return sysMenuId;
    }

    /**
     * 获取 权限描述
     * 
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 获取 状态
     * 
     * @return state
     */
    public Boolean getState() {
        return state;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}