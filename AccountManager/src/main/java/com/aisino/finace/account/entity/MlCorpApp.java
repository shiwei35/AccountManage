package com.aisino.finace.account.entity;

public class MlCorpApp {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_corp_app.APP_NO
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    private String appNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_corp_app.APP_NO
     *
     * @return the value of ml_corp_app.APP_NO
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public String getAppNo() {
        return appNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_corp_app.APP_NO
     *
     * @param appNo the value for ml_corp_app.APP_NO
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public void setAppNo(String appNo) {
        this.appNo = appNo == null ? null : appNo.trim();
    }
}