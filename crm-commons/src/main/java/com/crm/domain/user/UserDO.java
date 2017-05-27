package com.crm.domain.user;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.crm.domain.BaseDO;

/**
 * 
 * @author haisheng.long Tue Dec 30 19:15:56 CST 2014
 */

public class UserDO extends BaseDO {

    /**
     * <pre>
     * 
     * </pre>
     */
    private static final long serialVersionUID = -485650604307346368L;

    /** 主键 */
    private Long id;

    /** 登录名 */
    private String loginName;

    /** 用户名 */
    private String userName;

    /** 密码 */
    private String password;

    /** 登录盐 */
    private String salt;

    /** 部门id */
    private Long departmentId;

    private Long roleId;
    /** email */
    private String email;
    /** mobile */
    private String mobile;

    /** 创建人id */
    private Long createUserId;

    /** 修改人id */
    private Long modifyUserId;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date modifyTime;

    /** 最后一次登录时间 */
    private Date lastLoginTime;

    /** 最后一次登录ip */
    private String lastLoginIp;

    /** 用户状态 */
    private Boolean state;

    /** 用户扩展信息 */
    private UserDetailDO userDetail;

    /**
     * 设置 主键
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置 登录名
     * 
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 设置 用户名
     * 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 设置 密码
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 设置 登录盐
     * 
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 设置 部门id
     * 
     * @param departmentId
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
     * 设置 最后一次登录时间
     * 
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 设置 最后一次登录ip
     * 
     * @param lastLoginIp
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 设置 用户状态
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
     * 获取 登录名
     * 
     * @return loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 获取 用户名
     * 
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 获取 密码
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 获取 登录盐
     * 
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 获取 部门id
     * 
     * @return departmentId
     */
    public Long getDepartmentId() {
        return departmentId;
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
     * 获取 最后一次登录时间
     * 
     * @return lastLoginTime
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 获取 最后一次登录ip
     * 
     * @return lastLoginIp
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 获取 用户状态
     * 
     * @return state
     */
    public Boolean getState() {
        return state;
    }

    public String getCredentialsSalt() {
        return loginName + salt;
    }

    /**
     * 冗余数据，角色名称
     */
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<SysMenuDO> sysMenuList;

    private Map<String, Set<String>> pageBtnMap;

    public List<SysMenuDO> getSysMenuList() {
        return sysMenuList;
    }

    public void setSysMenuList(List<SysMenuDO> sysMenuList) {
        this.sysMenuList = sysMenuList;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public UserDetailDO getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailDO userDetail) {
        this.userDetail = userDetail;
    }

    public Map<String, Set<String>> getPageBtnMap() {
        return pageBtnMap;
    }

    public void setPageBtnMap(Map<String, Set<String>> pageBtnMap) {
        this.pageBtnMap = pageBtnMap;
    }

    @Override
    public String toString() {
        return "UserDO [id=" + id + ", loginName=" + loginName + ", userName=" + userName + ", password=" + password + ", salt=" + salt + ", departmentId="
                + departmentId + ", roleId=" + roleId + ", email=" + email + ", mobile=" + mobile + ", createUserId=" + createUserId + ", modifyUserId="
                + modifyUserId + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", lastLoginTime=" + lastLoginTime + ", lastLoginIp="
                + lastLoginIp + ", state=" + state + ", userDetail=" + (null != userDetail ? userDetail.toString() : null) + ", roleName=" + roleName
                + ", departmentName=" + departmentName + ", sysMenuList=" + sysMenuList + "]";
    }

}