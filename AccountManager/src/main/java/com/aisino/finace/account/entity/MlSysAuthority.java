package com.aisino.finace.account.entity;

import java.util.Date;

public class MlSysAuthority {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_authority.AUTH_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private Long authId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_authority.RESC_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private Long rescId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_authority.AUTH_CODE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private String authCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_authority.AUTH_DESC
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private String authDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_authority.CREATOR
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private Long creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_authority.CREATE_TIME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_authority.AUTH_ID
     *
     * @return the value of ml_sys_authority.AUTH_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Long getAuthId() {
        return authId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_authority.AUTH_ID
     *
     * @param authId the value for ml_sys_authority.AUTH_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_authority.RESC_ID
     *
     * @return the value of ml_sys_authority.RESC_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Long getRescId() {
        return rescId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_authority.RESC_ID
     *
     * @param rescId the value for ml_sys_authority.RESC_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setRescId(Long rescId) {
        this.rescId = rescId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_authority.AUTH_CODE
     *
     * @return the value of ml_sys_authority.AUTH_CODE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_authority.AUTH_CODE
     *
     * @param authCode the value for ml_sys_authority.AUTH_CODE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode == null ? null : authCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_authority.AUTH_DESC
     *
     * @return the value of ml_sys_authority.AUTH_DESC
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getAuthDesc() {
        return authDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_authority.AUTH_DESC
     *
     * @param authDesc the value for ml_sys_authority.AUTH_DESC
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc == null ? null : authDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_authority.CREATOR
     *
     * @return the value of ml_sys_authority.CREATOR
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_authority.CREATOR
     *
     * @param creator the value for ml_sys_authority.CREATOR
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_authority.CREATE_TIME
     *
     * @return the value of ml_sys_authority.CREATE_TIME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_authority.CREATE_TIME
     *
     * @param createTime the value for ml_sys_authority.CREATE_TIME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}