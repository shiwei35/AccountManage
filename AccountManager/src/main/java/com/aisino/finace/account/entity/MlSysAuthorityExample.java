package com.aisino.finace.account.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlSysAuthorityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public MlSysAuthorityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAuthIdIsNull() {
            addCriterion("AUTH_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNotNull() {
            addCriterion("AUTH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthIdEqualTo(Long value) {
            addCriterion("AUTH_ID =", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotEqualTo(Long value) {
            addCriterion("AUTH_ID <>", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThan(Long value) {
            addCriterion("AUTH_ID >", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThanOrEqualTo(Long value) {
            addCriterion("AUTH_ID >=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThan(Long value) {
            addCriterion("AUTH_ID <", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThanOrEqualTo(Long value) {
            addCriterion("AUTH_ID <=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdIn(List<Long> values) {
            addCriterion("AUTH_ID in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotIn(List<Long> values) {
            addCriterion("AUTH_ID not in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdBetween(Long value1, Long value2) {
            addCriterion("AUTH_ID between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotBetween(Long value1, Long value2) {
            addCriterion("AUTH_ID not between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andRescIdIsNull() {
            addCriterion("RESC_ID is null");
            return (Criteria) this;
        }

        public Criteria andRescIdIsNotNull() {
            addCriterion("RESC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRescIdEqualTo(Long value) {
            addCriterion("RESC_ID =", value, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdNotEqualTo(Long value) {
            addCriterion("RESC_ID <>", value, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdGreaterThan(Long value) {
            addCriterion("RESC_ID >", value, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdGreaterThanOrEqualTo(Long value) {
            addCriterion("RESC_ID >=", value, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdLessThan(Long value) {
            addCriterion("RESC_ID <", value, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdLessThanOrEqualTo(Long value) {
            addCriterion("RESC_ID <=", value, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdIn(List<Long> values) {
            addCriterion("RESC_ID in", values, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdNotIn(List<Long> values) {
            addCriterion("RESC_ID not in", values, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdBetween(Long value1, Long value2) {
            addCriterion("RESC_ID between", value1, value2, "rescId");
            return (Criteria) this;
        }

        public Criteria andRescIdNotBetween(Long value1, Long value2) {
            addCriterion("RESC_ID not between", value1, value2, "rescId");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIsNull() {
            addCriterion("AUTH_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIsNotNull() {
            addCriterion("AUTH_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAuthCodeEqualTo(String value) {
            addCriterion("AUTH_CODE =", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotEqualTo(String value) {
            addCriterion("AUTH_CODE <>", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeGreaterThan(String value) {
            addCriterion("AUTH_CODE >", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_CODE >=", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLessThan(String value) {
            addCriterion("AUTH_CODE <", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLessThanOrEqualTo(String value) {
            addCriterion("AUTH_CODE <=", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLike(String value) {
            addCriterion("AUTH_CODE like", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotLike(String value) {
            addCriterion("AUTH_CODE not like", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIn(List<String> values) {
            addCriterion("AUTH_CODE in", values, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotIn(List<String> values) {
            addCriterion("AUTH_CODE not in", values, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeBetween(String value1, String value2) {
            addCriterion("AUTH_CODE between", value1, value2, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotBetween(String value1, String value2) {
            addCriterion("AUTH_CODE not between", value1, value2, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthDescIsNull() {
            addCriterion("AUTH_DESC is null");
            return (Criteria) this;
        }

        public Criteria andAuthDescIsNotNull() {
            addCriterion("AUTH_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andAuthDescEqualTo(String value) {
            addCriterion("AUTH_DESC =", value, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescNotEqualTo(String value) {
            addCriterion("AUTH_DESC <>", value, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescGreaterThan(String value) {
            addCriterion("AUTH_DESC >", value, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_DESC >=", value, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescLessThan(String value) {
            addCriterion("AUTH_DESC <", value, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescLessThanOrEqualTo(String value) {
            addCriterion("AUTH_DESC <=", value, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescLike(String value) {
            addCriterion("AUTH_DESC like", value, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescNotLike(String value) {
            addCriterion("AUTH_DESC not like", value, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescIn(List<String> values) {
            addCriterion("AUTH_DESC in", values, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescNotIn(List<String> values) {
            addCriterion("AUTH_DESC not in", values, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescBetween(String value1, String value2) {
            addCriterion("AUTH_DESC between", value1, value2, "authDesc");
            return (Criteria) this;
        }

        public Criteria andAuthDescNotBetween(String value1, String value2) {
            addCriterion("AUTH_DESC not between", value1, value2, "authDesc");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(Long value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Long value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Long value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Long value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Long value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Long> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Long> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Long value1, Long value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Long value1, Long value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_sys_authority
     *
     * @mbggenerated do_not_delete_during_merge Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_sys_authority
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}