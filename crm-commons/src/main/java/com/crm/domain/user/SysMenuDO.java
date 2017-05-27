package com.crm.domain.user;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.crm.domain.BaseDO;

/**
 * 菜单
 * 
 * @author haisheng.long Tue Dec 30 19:15:56 CST 2014
 */

public class SysMenuDO extends BaseDO {

    public static Integer MENU_TYPE_1 = 1;
    public static Integer MENU_TYPE_2 = 2;

    /**
     * <pre>
     * 
     * </pre>
     */
    private static final long serialVersionUID = -4795844586322991717L;

    /** 主键 */
    private Long id;

    /***/
    private String code;

    /** 父菜单id，如果为空，则为根菜单 */
    private Long parentId;

    /** 菜单名称 */
    private String name;

    /** 菜单请求链接 */
    private String url;

    /** 菜单请求链接 */
    private String category;

    /** 菜单类型 1：菜单 2：按钮 */
    private Integer menuType;

    /** 创建人id */
    private Long createUserId;

    /** 修改人id */
    private Long modifyUserId;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date modifyTime;

    /** 状态 */
    private Boolean state;

    public SysMenuDO() {
    }

    public SysMenuDO(Long id, Long parentId, String name, String url, String category, Long createUserId, Long modifyUserId, Date createTime, Date modifyTime,
            Boolean state) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.url = url;
        this.category = category;
        this.createUserId = createUserId;
        this.modifyUserId = modifyUserId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.state = state;
    }

    public SysMenuDO(Long id, Long parentId, String name, String url, String category, Long createUserId, Long modifyUserId, Date createTime, Date modifyTime,
            Boolean state, Long location) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.url = url;
        this.category = category;
        this.createUserId = createUserId;
        this.modifyUserId = modifyUserId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.state = state;
        this.location = location;
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
     * 设置 父菜单id，如果为空，则为根菜单
     * 
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 设置 菜单名称
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置 菜单请求链接
     * 
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 设置 创建人id
     * 
     * @param createUserId
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 设置 修改人id
     * 
     * @param modifyUserId
     */
    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    /**
     * 设置 创建时间
     * 
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 设置 修改时间
     * 
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
     * 获取 父菜单id，如果为空，则为根菜单
     * 
     * @return parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 获取 菜单名称
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 获取 菜单请求链接
     * 
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 获取 创建人id
     * 
     * @return createUserId
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 获取 修改人id
     * 
     * @return modifyUserId
     */
    public Long getModifyUserId() {
        return modifyUserId;
    }

    /**
     * 获取 创建时间
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 获取 修改时间
     * 
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 获取 状态
     * 
     * @return state
     */
    public Boolean getState() {
        return state;
    }

    private Long location;

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("state", this.state).append("startPage", this.getStartPage()).append("createUserId", this.createUserId)
                .append("menuType", this.menuType).append("code", this.code).append("parentId", this.parentId).append("location", this.location)
                .append("start", this.getStart()).append("category", this.category).append("url", this.url).append("modifyUserId", this.modifyUserId)
                .append("createTime", this.createTime).append("name", this.name).append("pageSize", this.getPageSize()).append("modifyTime", this.modifyTime)
                .append("id", this.id).toString();
    }

}