package com.crm.domain;

public class CityDO extends BaseDO {

    /**
     */
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /**  */
    private String name;

    /**  */
    private Long provinceId;

    /**  */
    private String postcode;

    /** 排序 */
    private Integer order;

    /**
     * 设置 主键
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置
     * 
     * @param provinceId
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 设置
     * 
     * @param postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * 设置 排序
     * 
     * @param order
     */
    public void setOrder(Integer order) {
        this.order = order;
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
     * 获取
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 获取
     * 
     * @return provinceId
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 获取
     * 
     * @return postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 获取 排序
     * 
     * @return order
     */
    public Integer getOrder() {
        return order;
    }

}