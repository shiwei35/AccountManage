package com.aisino.finace.account.entity;

public class MlSysKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_key.TABLE_NAME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private String tableName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_key.KEY_NAME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private String keyName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_key.KEY_VALUE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private Long keyValue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_key.TABLE_NAME
     *
     * @return the value of ml_sys_key.TABLE_NAME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_key.TABLE_NAME
     *
     * @param tableName the value for ml_sys_key.TABLE_NAME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_key.KEY_NAME
     *
     * @return the value of ml_sys_key.KEY_NAME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_key.KEY_NAME
     *
     * @param keyName the value for ml_sys_key.KEY_NAME
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_key.KEY_VALUE
     *
     * @return the value of ml_sys_key.KEY_VALUE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Long getKeyValue() {
        return keyValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_key.KEY_VALUE
     *
     * @param keyValue the value for ml_sys_key.KEY_VALUE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setKeyValue(Long keyValue) {
        this.keyValue = keyValue;
    }
}