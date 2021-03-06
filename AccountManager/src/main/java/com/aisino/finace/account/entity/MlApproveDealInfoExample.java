package com.aisino.finace.account.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlApproveDealInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public MlApproveDealInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
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
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
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

        public Criteria andAppNoIsNull() {
            addCriterion("APP_NO is null");
            return (Criteria) this;
        }

        public Criteria andAppNoIsNotNull() {
            addCriterion("APP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAppNoEqualTo(String value) {
            addCriterion("APP_NO =", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotEqualTo(String value) {
            addCriterion("APP_NO <>", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoGreaterThan(String value) {
            addCriterion("APP_NO >", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoGreaterThanOrEqualTo(String value) {
            addCriterion("APP_NO >=", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLessThan(String value) {
            addCriterion("APP_NO <", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLessThanOrEqualTo(String value) {
            addCriterion("APP_NO <=", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLike(String value) {
            addCriterion("APP_NO like", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotLike(String value) {
            addCriterion("APP_NO not like", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoIn(List<String> values) {
            addCriterion("APP_NO in", values, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotIn(List<String> values) {
            addCriterion("APP_NO not in", values, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoBetween(String value1, String value2) {
            addCriterion("APP_NO between", value1, value2, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotBetween(String value1, String value2) {
            addCriterion("APP_NO not between", value1, value2, "appNo");
            return (Criteria) this;
        }

        public Criteria andDealIdIsNull() {
            addCriterion("DEAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andDealIdIsNotNull() {
            addCriterion("DEAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDealIdEqualTo(Long value) {
            addCriterion("DEAL_ID =", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotEqualTo(Long value) {
            addCriterion("DEAL_ID <>", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdGreaterThan(Long value) {
            addCriterion("DEAL_ID >", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DEAL_ID >=", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdLessThan(Long value) {
            addCriterion("DEAL_ID <", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdLessThanOrEqualTo(Long value) {
            addCriterion("DEAL_ID <=", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdIn(List<Long> values) {
            addCriterion("DEAL_ID in", values, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotIn(List<Long> values) {
            addCriterion("DEAL_ID not in", values, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdBetween(Long value1, Long value2) {
            addCriterion("DEAL_ID between", value1, value2, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotBetween(Long value1, Long value2) {
            addCriterion("DEAL_ID not between", value1, value2, "dealId");
            return (Criteria) this;
        }

        public Criteria andCurrStepIsNull() {
            addCriterion("CURR_STEP is null");
            return (Criteria) this;
        }

        public Criteria andCurrStepIsNotNull() {
            addCriterion("CURR_STEP is not null");
            return (Criteria) this;
        }

        public Criteria andCurrStepEqualTo(String value) {
            addCriterion("CURR_STEP =", value, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepNotEqualTo(String value) {
            addCriterion("CURR_STEP <>", value, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepGreaterThan(String value) {
            addCriterion("CURR_STEP >", value, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepGreaterThanOrEqualTo(String value) {
            addCriterion("CURR_STEP >=", value, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepLessThan(String value) {
            addCriterion("CURR_STEP <", value, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepLessThanOrEqualTo(String value) {
            addCriterion("CURR_STEP <=", value, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepLike(String value) {
            addCriterion("CURR_STEP like", value, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepNotLike(String value) {
            addCriterion("CURR_STEP not like", value, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepIn(List<String> values) {
            addCriterion("CURR_STEP in", values, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepNotIn(List<String> values) {
            addCriterion("CURR_STEP not in", values, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepBetween(String value1, String value2) {
            addCriterion("CURR_STEP between", value1, value2, "currStep");
            return (Criteria) this;
        }

        public Criteria andCurrStepNotBetween(String value1, String value2) {
            addCriterion("CURR_STEP not between", value1, value2, "currStep");
            return (Criteria) this;
        }

        public Criteria andHandlerIsNull() {
            addCriterion("HANDLER is null");
            return (Criteria) this;
        }

        public Criteria andHandlerIsNotNull() {
            addCriterion("HANDLER is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerEqualTo(Long value) {
            addCriterion("HANDLER =", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotEqualTo(Long value) {
            addCriterion("HANDLER <>", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerGreaterThan(Long value) {
            addCriterion("HANDLER >", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerGreaterThanOrEqualTo(Long value) {
            addCriterion("HANDLER >=", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLessThan(Long value) {
            addCriterion("HANDLER <", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLessThanOrEqualTo(Long value) {
            addCriterion("HANDLER <=", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerIn(List<Long> values) {
            addCriterion("HANDLER in", values, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotIn(List<Long> values) {
            addCriterion("HANDLER not in", values, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerBetween(Long value1, Long value2) {
            addCriterion("HANDLER between", value1, value2, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotBetween(Long value1, Long value2) {
            addCriterion("HANDLER not between", value1, value2, "handler");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNull() {
            addCriterion("DEAL_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNotNull() {
            addCriterion("DEAL_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andDealResultEqualTo(String value) {
            addCriterion("DEAL_RESULT =", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotEqualTo(String value) {
            addCriterion("DEAL_RESULT <>", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThan(String value) {
            addCriterion("DEAL_RESULT >", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_RESULT >=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThan(String value) {
            addCriterion("DEAL_RESULT <", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThanOrEqualTo(String value) {
            addCriterion("DEAL_RESULT <=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLike(String value) {
            addCriterion("DEAL_RESULT like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotLike(String value) {
            addCriterion("DEAL_RESULT not like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultIn(List<String> values) {
            addCriterion("DEAL_RESULT in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotIn(List<String> values) {
            addCriterion("DEAL_RESULT not in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultBetween(String value1, String value2) {
            addCriterion("DEAL_RESULT between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotBetween(String value1, String value2) {
            addCriterion("DEAL_RESULT not between", value1, value2, "dealResult");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated do_not_delete_during_merge Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
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