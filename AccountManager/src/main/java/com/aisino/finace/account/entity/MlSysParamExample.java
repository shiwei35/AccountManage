package com.aisino.finace.account.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlSysParamExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public MlSysParamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
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
     * This method corresponds to the database table ml_sys_param
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
     * This method corresponds to the database table ml_sys_param
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_sys_param
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
     * This class corresponds to the database table ml_sys_param
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

        public Criteria andParamIdIsNull() {
            addCriterion("PARAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andParamIdIsNotNull() {
            addCriterion("PARAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParamIdEqualTo(Long value) {
            addCriterion("PARAM_ID =", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotEqualTo(Long value) {
            addCriterion("PARAM_ID <>", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdGreaterThan(Long value) {
            addCriterion("PARAM_ID >", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARAM_ID >=", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLessThan(Long value) {
            addCriterion("PARAM_ID <", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLessThanOrEqualTo(Long value) {
            addCriterion("PARAM_ID <=", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdIn(List<Long> values) {
            addCriterion("PARAM_ID in", values, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotIn(List<Long> values) {
            addCriterion("PARAM_ID not in", values, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdBetween(Long value1, Long value2) {
            addCriterion("PARAM_ID between", value1, value2, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotBetween(Long value1, Long value2) {
            addCriterion("PARAM_ID not between", value1, value2, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamTitleIsNull() {
            addCriterion("PARAM_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andParamTitleIsNotNull() {
            addCriterion("PARAM_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andParamTitleEqualTo(String value) {
            addCriterion("PARAM_TITLE =", value, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleNotEqualTo(String value) {
            addCriterion("PARAM_TITLE <>", value, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleGreaterThan(String value) {
            addCriterion("PARAM_TITLE >", value, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_TITLE >=", value, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleLessThan(String value) {
            addCriterion("PARAM_TITLE <", value, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleLessThanOrEqualTo(String value) {
            addCriterion("PARAM_TITLE <=", value, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleLike(String value) {
            addCriterion("PARAM_TITLE like", value, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleNotLike(String value) {
            addCriterion("PARAM_TITLE not like", value, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleIn(List<String> values) {
            addCriterion("PARAM_TITLE in", values, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleNotIn(List<String> values) {
            addCriterion("PARAM_TITLE not in", values, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleBetween(String value1, String value2) {
            addCriterion("PARAM_TITLE between", value1, value2, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamTitleNotBetween(String value1, String value2) {
            addCriterion("PARAM_TITLE not between", value1, value2, "paramTitle");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNull() {
            addCriterion("PARAM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNotNull() {
            addCriterion("PARAM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParamCodeEqualTo(String value) {
            addCriterion("PARAM_CODE =", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotEqualTo(String value) {
            addCriterion("PARAM_CODE <>", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThan(String value) {
            addCriterion("PARAM_CODE >", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_CODE >=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThan(String value) {
            addCriterion("PARAM_CODE <", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_CODE <=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLike(String value) {
            addCriterion("PARAM_CODE like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotLike(String value) {
            addCriterion("PARAM_CODE not like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeIn(List<String> values) {
            addCriterion("PARAM_CODE in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotIn(List<String> values) {
            addCriterion("PARAM_CODE not in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeBetween(String value1, String value2) {
            addCriterion("PARAM_CODE between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotBetween(String value1, String value2) {
            addCriterion("PARAM_CODE not between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamValIsNull() {
            addCriterion("PARAM_VAL is null");
            return (Criteria) this;
        }

        public Criteria andParamValIsNotNull() {
            addCriterion("PARAM_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andParamValEqualTo(String value) {
            addCriterion("PARAM_VAL =", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotEqualTo(String value) {
            addCriterion("PARAM_VAL <>", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValGreaterThan(String value) {
            addCriterion("PARAM_VAL >", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_VAL >=", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLessThan(String value) {
            addCriterion("PARAM_VAL <", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLessThanOrEqualTo(String value) {
            addCriterion("PARAM_VAL <=", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLike(String value) {
            addCriterion("PARAM_VAL like", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotLike(String value) {
            addCriterion("PARAM_VAL not like", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValIn(List<String> values) {
            addCriterion("PARAM_VAL in", values, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotIn(List<String> values) {
            addCriterion("PARAM_VAL not in", values, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValBetween(String value1, String value2) {
            addCriterion("PARAM_VAL between", value1, value2, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotBetween(String value1, String value2) {
            addCriterion("PARAM_VAL not between", value1, value2, "paramVal");
            return (Criteria) this;
        }

        public Criteria andModuleIsNull() {
            addCriterion("MODULE is null");
            return (Criteria) this;
        }

        public Criteria andModuleIsNotNull() {
            addCriterion("MODULE is not null");
            return (Criteria) this;
        }

        public Criteria andModuleEqualTo(String value) {
            addCriterion("MODULE =", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotEqualTo(String value) {
            addCriterion("MODULE <>", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThan(String value) {
            addCriterion("MODULE >", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE >=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThan(String value) {
            addCriterion("MODULE <", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThanOrEqualTo(String value) {
            addCriterion("MODULE <=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLike(String value) {
            addCriterion("MODULE like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotLike(String value) {
            addCriterion("MODULE not like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleIn(List<String> values) {
            addCriterion("MODULE in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotIn(List<String> values) {
            addCriterion("MODULE not in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleBetween(String value1, String value2) {
            addCriterion("MODULE between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotBetween(String value1, String value2) {
            addCriterion("MODULE not between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNull() {
            addCriterion("OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNotNull() {
            addCriterion("OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperIdEqualTo(Long value) {
            addCriterion("OPER_ID =", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotEqualTo(Long value) {
            addCriterion("OPER_ID <>", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThan(Long value) {
            addCriterion("OPER_ID >", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OPER_ID >=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThan(Long value) {
            addCriterion("OPER_ID <", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThanOrEqualTo(Long value) {
            addCriterion("OPER_ID <=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdIn(List<Long> values) {
            addCriterion("OPER_ID in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotIn(List<Long> values) {
            addCriterion("OPER_ID not in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdBetween(Long value1, Long value2) {
            addCriterion("OPER_ID between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotBetween(Long value1, Long value2) {
            addCriterion("OPER_ID not between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOpTimeIsNull() {
            addCriterion("OP_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOpTimeIsNotNull() {
            addCriterion("OP_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOpTimeEqualTo(Date value) {
            addCriterion("OP_TIME =", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotEqualTo(Date value) {
            addCriterion("OP_TIME <>", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeGreaterThan(Date value) {
            addCriterion("OP_TIME >", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OP_TIME >=", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeLessThan(Date value) {
            addCriterion("OP_TIME <", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeLessThanOrEqualTo(Date value) {
            addCriterion("OP_TIME <=", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeIn(List<Date> values) {
            addCriterion("OP_TIME in", values, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotIn(List<Date> values) {
            addCriterion("OP_TIME not in", values, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeBetween(Date value1, Date value2) {
            addCriterion("OP_TIME between", value1, value2, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotBetween(Date value1, Date value2) {
            addCriterion("OP_TIME not between", value1, value2, "opTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_sys_param
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
     * This class corresponds to the database table ml_sys_param
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