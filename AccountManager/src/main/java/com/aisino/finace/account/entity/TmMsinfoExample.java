package com.aisino.finace.account.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TmMsinfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public TmMsinfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andSMsuuidIsNull() {
			addCriterion("S_MSUUID is null");
			return (Criteria) this;
		}

		public Criteria andSMsuuidIsNotNull() {
			addCriterion("S_MSUUID is not null");
			return (Criteria) this;
		}

		public Criteria andSMsuuidEqualTo(String value) {
			addCriterion("S_MSUUID =", value, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidNotEqualTo(String value) {
			addCriterion("S_MSUUID <>", value, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidGreaterThan(String value) {
			addCriterion("S_MSUUID >", value, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidGreaterThanOrEqualTo(String value) {
			addCriterion("S_MSUUID >=", value, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidLessThan(String value) {
			addCriterion("S_MSUUID <", value, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidLessThanOrEqualTo(String value) {
			addCriterion("S_MSUUID <=", value, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidLike(String value) {
			addCriterion("S_MSUUID like", value, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidNotLike(String value) {
			addCriterion("S_MSUUID not like", value, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidIn(List<String> values) {
			addCriterion("S_MSUUID in", values, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidNotIn(List<String> values) {
			addCriterion("S_MSUUID not in", values, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidBetween(String value1, String value2) {
			addCriterion("S_MSUUID between", value1, value2, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSMsuuidNotBetween(String value1, String value2) {
			addCriterion("S_MSUUID not between", value1, value2, "sMsuuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidIsNull() {
			addCriterion("S_ORGUUID is null");
			return (Criteria) this;
		}

		public Criteria andSOrguuidIsNotNull() {
			addCriterion("S_ORGUUID is not null");
			return (Criteria) this;
		}

		public Criteria andSOrguuidEqualTo(String value) {
			addCriterion("S_ORGUUID =", value, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidNotEqualTo(String value) {
			addCriterion("S_ORGUUID <>", value, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidGreaterThan(String value) {
			addCriterion("S_ORGUUID >", value, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidGreaterThanOrEqualTo(String value) {
			addCriterion("S_ORGUUID >=", value, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidLessThan(String value) {
			addCriterion("S_ORGUUID <", value, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidLessThanOrEqualTo(String value) {
			addCriterion("S_ORGUUID <=", value, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidLike(String value) {
			addCriterion("S_ORGUUID like", value, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidNotLike(String value) {
			addCriterion("S_ORGUUID not like", value, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidIn(List<String> values) {
			addCriterion("S_ORGUUID in", values, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidNotIn(List<String> values) {
			addCriterion("S_ORGUUID not in", values, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidBetween(String value1, String value2) {
			addCriterion("S_ORGUUID between", value1, value2, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andSOrguuidNotBetween(String value1, String value2) {
			addCriterion("S_ORGUUID not between", value1, value2, "sOrguuid");
			return (Criteria) this;
		}

		public Criteria andIMercodeIsNull() {
			addCriterion("I_MERCODE is null");
			return (Criteria) this;
		}

		public Criteria andIMercodeIsNotNull() {
			addCriterion("I_MERCODE is not null");
			return (Criteria) this;
		}

		public Criteria andIMercodeEqualTo(Long value) {
			addCriterion("I_MERCODE =", value, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeNotEqualTo(Long value) {
			addCriterion("I_MERCODE <>", value, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeGreaterThan(Long value) {
			addCriterion("I_MERCODE >", value, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeGreaterThanOrEqualTo(Long value) {
			addCriterion("I_MERCODE >=", value, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeLessThan(Long value) {
			addCriterion("I_MERCODE <", value, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeLessThanOrEqualTo(Long value) {
			addCriterion("I_MERCODE <=", value, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeIn(List<Long> values) {
			addCriterion("I_MERCODE in", values, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeNotIn(List<Long> values) {
			addCriterion("I_MERCODE not in", values, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeBetween(Long value1, Long value2) {
			addCriterion("I_MERCODE between", value1, value2, "iMercode");
			return (Criteria) this;
		}

		public Criteria andIMercodeNotBetween(Long value1, Long value2) {
			addCriterion("I_MERCODE not between", value1, value2, "iMercode");
			return (Criteria) this;
		}

		public Criteria andSMsnameIsNull() {
			addCriterion("S_MSNAME is null");
			return (Criteria) this;
		}

		public Criteria andSMsnameIsNotNull() {
			addCriterion("S_MSNAME is not null");
			return (Criteria) this;
		}

		public Criteria andSMsnameEqualTo(String value) {
			addCriterion("S_MSNAME =", value, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameNotEqualTo(String value) {
			addCriterion("S_MSNAME <>", value, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameGreaterThan(String value) {
			addCriterion("S_MSNAME >", value, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameGreaterThanOrEqualTo(String value) {
			addCriterion("S_MSNAME >=", value, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameLessThan(String value) {
			addCriterion("S_MSNAME <", value, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameLessThanOrEqualTo(String value) {
			addCriterion("S_MSNAME <=", value, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameLike(String value) {
			addCriterion("S_MSNAME like", value, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameNotLike(String value) {
			addCriterion("S_MSNAME not like", value, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameIn(List<String> values) {
			addCriterion("S_MSNAME in", values, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameNotIn(List<String> values) {
			addCriterion("S_MSNAME not in", values, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameBetween(String value1, String value2) {
			addCriterion("S_MSNAME between", value1, value2, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsnameNotBetween(String value1, String value2) {
			addCriterion("S_MSNAME not between", value1, value2, "sMsname");
			return (Criteria) this;
		}

		public Criteria andSMsstatusIsNull() {
			addCriterion("S_MSSTATUS is null");
			return (Criteria) this;
		}

		public Criteria andSMsstatusIsNotNull() {
			addCriterion("S_MSSTATUS is not null");
			return (Criteria) this;
		}

		public Criteria andSMsstatusEqualTo(String value) {
			addCriterion("S_MSSTATUS =", value, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusNotEqualTo(String value) {
			addCriterion("S_MSSTATUS <>", value, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusGreaterThan(String value) {
			addCriterion("S_MSSTATUS >", value, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusGreaterThanOrEqualTo(String value) {
			addCriterion("S_MSSTATUS >=", value, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusLessThan(String value) {
			addCriterion("S_MSSTATUS <", value, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusLessThanOrEqualTo(String value) {
			addCriterion("S_MSSTATUS <=", value, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusLike(String value) {
			addCriterion("S_MSSTATUS like", value, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusNotLike(String value) {
			addCriterion("S_MSSTATUS not like", value, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusIn(List<String> values) {
			addCriterion("S_MSSTATUS in", values, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusNotIn(List<String> values) {
			addCriterion("S_MSSTATUS not in", values, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusBetween(String value1, String value2) {
			addCriterion("S_MSSTATUS between", value1, value2, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSMsstatusNotBetween(String value1, String value2) {
			addCriterion("S_MSSTATUS not between", value1, value2, "sMsstatus");
			return (Criteria) this;
		}

		public Criteria andSCitycodeIsNull() {
			addCriterion("S_CITYCODE is null");
			return (Criteria) this;
		}

		public Criteria andSCitycodeIsNotNull() {
			addCriterion("S_CITYCODE is not null");
			return (Criteria) this;
		}

		public Criteria andSCitycodeEqualTo(String value) {
			addCriterion("S_CITYCODE =", value, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeNotEqualTo(String value) {
			addCriterion("S_CITYCODE <>", value, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeGreaterThan(String value) {
			addCriterion("S_CITYCODE >", value, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeGreaterThanOrEqualTo(String value) {
			addCriterion("S_CITYCODE >=", value, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeLessThan(String value) {
			addCriterion("S_CITYCODE <", value, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeLessThanOrEqualTo(String value) {
			addCriterion("S_CITYCODE <=", value, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeLike(String value) {
			addCriterion("S_CITYCODE like", value, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeNotLike(String value) {
			addCriterion("S_CITYCODE not like", value, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeIn(List<String> values) {
			addCriterion("S_CITYCODE in", values, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeNotIn(List<String> values) {
			addCriterion("S_CITYCODE not in", values, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeBetween(String value1, String value2) {
			addCriterion("S_CITYCODE between", value1, value2, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitycodeNotBetween(String value1, String value2) {
			addCriterion("S_CITYCODE not between", value1, value2, "sCitycode");
			return (Criteria) this;
		}

		public Criteria andSCitynameIsNull() {
			addCriterion("S_CITYNAME is null");
			return (Criteria) this;
		}

		public Criteria andSCitynameIsNotNull() {
			addCriterion("S_CITYNAME is not null");
			return (Criteria) this;
		}

		public Criteria andSCitynameEqualTo(String value) {
			addCriterion("S_CITYNAME =", value, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameNotEqualTo(String value) {
			addCriterion("S_CITYNAME <>", value, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameGreaterThan(String value) {
			addCriterion("S_CITYNAME >", value, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameGreaterThanOrEqualTo(String value) {
			addCriterion("S_CITYNAME >=", value, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameLessThan(String value) {
			addCriterion("S_CITYNAME <", value, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameLessThanOrEqualTo(String value) {
			addCriterion("S_CITYNAME <=", value, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameLike(String value) {
			addCriterion("S_CITYNAME like", value, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameNotLike(String value) {
			addCriterion("S_CITYNAME not like", value, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameIn(List<String> values) {
			addCriterion("S_CITYNAME in", values, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameNotIn(List<String> values) {
			addCriterion("S_CITYNAME not in", values, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameBetween(String value1, String value2) {
			addCriterion("S_CITYNAME between", value1, value2, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSCitynameNotBetween(String value1, String value2) {
			addCriterion("S_CITYNAME not between", value1, value2, "sCityname");
			return (Criteria) this;
		}

		public Criteria andSMsaddrIsNull() {
			addCriterion("S_MSADDR is null");
			return (Criteria) this;
		}

		public Criteria andSMsaddrIsNotNull() {
			addCriterion("S_MSADDR is not null");
			return (Criteria) this;
		}

		public Criteria andSMsaddrEqualTo(String value) {
			addCriterion("S_MSADDR =", value, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrNotEqualTo(String value) {
			addCriterion("S_MSADDR <>", value, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrGreaterThan(String value) {
			addCriterion("S_MSADDR >", value, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrGreaterThanOrEqualTo(String value) {
			addCriterion("S_MSADDR >=", value, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrLessThan(String value) {
			addCriterion("S_MSADDR <", value, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrLessThanOrEqualTo(String value) {
			addCriterion("S_MSADDR <=", value, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrLike(String value) {
			addCriterion("S_MSADDR like", value, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrNotLike(String value) {
			addCriterion("S_MSADDR not like", value, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrIn(List<String> values) {
			addCriterion("S_MSADDR in", values, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrNotIn(List<String> values) {
			addCriterion("S_MSADDR not in", values, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrBetween(String value1, String value2) {
			addCriterion("S_MSADDR between", value1, value2, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMsaddrNotBetween(String value1, String value2) {
			addCriterion("S_MSADDR not between", value1, value2, "sMsaddr");
			return (Criteria) this;
		}

		public Criteria andSMszipIsNull() {
			addCriterion("S_MSZIP is null");
			return (Criteria) this;
		}

		public Criteria andSMszipIsNotNull() {
			addCriterion("S_MSZIP is not null");
			return (Criteria) this;
		}

		public Criteria andSMszipEqualTo(String value) {
			addCriterion("S_MSZIP =", value, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipNotEqualTo(String value) {
			addCriterion("S_MSZIP <>", value, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipGreaterThan(String value) {
			addCriterion("S_MSZIP >", value, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipGreaterThanOrEqualTo(String value) {
			addCriterion("S_MSZIP >=", value, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipLessThan(String value) {
			addCriterion("S_MSZIP <", value, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipLessThanOrEqualTo(String value) {
			addCriterion("S_MSZIP <=", value, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipLike(String value) {
			addCriterion("S_MSZIP like", value, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipNotLike(String value) {
			addCriterion("S_MSZIP not like", value, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipIn(List<String> values) {
			addCriterion("S_MSZIP in", values, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipNotIn(List<String> values) {
			addCriterion("S_MSZIP not in", values, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipBetween(String value1, String value2) {
			addCriterion("S_MSZIP between", value1, value2, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMszipNotBetween(String value1, String value2) {
			addCriterion("S_MSZIP not between", value1, value2, "sMszip");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameIsNull() {
			addCriterion("S_MSMANAGERNAME is null");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameIsNotNull() {
			addCriterion("S_MSMANAGERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameEqualTo(String value) {
			addCriterion("S_MSMANAGERNAME =", value, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameNotEqualTo(String value) {
			addCriterion("S_MSMANAGERNAME <>", value, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameGreaterThan(String value) {
			addCriterion("S_MSMANAGERNAME >", value, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameGreaterThanOrEqualTo(String value) {
			addCriterion("S_MSMANAGERNAME >=", value, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameLessThan(String value) {
			addCriterion("S_MSMANAGERNAME <", value, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameLessThanOrEqualTo(String value) {
			addCriterion("S_MSMANAGERNAME <=", value, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameLike(String value) {
			addCriterion("S_MSMANAGERNAME like", value, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameNotLike(String value) {
			addCriterion("S_MSMANAGERNAME not like", value, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameIn(List<String> values) {
			addCriterion("S_MSMANAGERNAME in", values, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameNotIn(List<String> values) {
			addCriterion("S_MSMANAGERNAME not in", values, "sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameBetween(String value1, String value2) {
			addCriterion("S_MSMANAGERNAME between", value1, value2,
					"sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagernameNotBetween(String value1, String value2) {
			addCriterion("S_MSMANAGERNAME not between", value1, value2,
					"sMsmanagername");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneIsNull() {
			addCriterion("S_MSMANAGERPHONE is null");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneIsNotNull() {
			addCriterion("S_MSMANAGERPHONE is not null");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneEqualTo(String value) {
			addCriterion("S_MSMANAGERPHONE =", value, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneNotEqualTo(String value) {
			addCriterion("S_MSMANAGERPHONE <>", value, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneGreaterThan(String value) {
			addCriterion("S_MSMANAGERPHONE >", value, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneGreaterThanOrEqualTo(String value) {
			addCriterion("S_MSMANAGERPHONE >=", value, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneLessThan(String value) {
			addCriterion("S_MSMANAGERPHONE <", value, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneLessThanOrEqualTo(String value) {
			addCriterion("S_MSMANAGERPHONE <=", value, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneLike(String value) {
			addCriterion("S_MSMANAGERPHONE like", value, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneNotLike(String value) {
			addCriterion("S_MSMANAGERPHONE not like", value, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneIn(List<String> values) {
			addCriterion("S_MSMANAGERPHONE in", values, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneNotIn(List<String> values) {
			addCriterion("S_MSMANAGERPHONE not in", values, "sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneBetween(String value1, String value2) {
			addCriterion("S_MSMANAGERPHONE between", value1, value2,
					"sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSMsmanagerphoneNotBetween(String value1,
				String value2) {
			addCriterion("S_MSMANAGERPHONE not between", value1, value2,
					"sMsmanagerphone");
			return (Criteria) this;
		}

		public Criteria andSEmailIsNull() {
			addCriterion("S_EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andSEmailIsNotNull() {
			addCriterion("S_EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andSEmailEqualTo(String value) {
			addCriterion("S_EMAIL =", value, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailNotEqualTo(String value) {
			addCriterion("S_EMAIL <>", value, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailGreaterThan(String value) {
			addCriterion("S_EMAIL >", value, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailGreaterThanOrEqualTo(String value) {
			addCriterion("S_EMAIL >=", value, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailLessThan(String value) {
			addCriterion("S_EMAIL <", value, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailLessThanOrEqualTo(String value) {
			addCriterion("S_EMAIL <=", value, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailLike(String value) {
			addCriterion("S_EMAIL like", value, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailNotLike(String value) {
			addCriterion("S_EMAIL not like", value, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailIn(List<String> values) {
			addCriterion("S_EMAIL in", values, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailNotIn(List<String> values) {
			addCriterion("S_EMAIL not in", values, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailBetween(String value1, String value2) {
			addCriterion("S_EMAIL between", value1, value2, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSEmailNotBetween(String value1, String value2) {
			addCriterion("S_EMAIL not between", value1, value2, "sEmail");
			return (Criteria) this;
		}

		public Criteria andSRemarkIsNull() {
			addCriterion("S_REMARK is null");
			return (Criteria) this;
		}

		public Criteria andSRemarkIsNotNull() {
			addCriterion("S_REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andSRemarkEqualTo(String value) {
			addCriterion("S_REMARK =", value, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkNotEqualTo(String value) {
			addCriterion("S_REMARK <>", value, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkGreaterThan(String value) {
			addCriterion("S_REMARK >", value, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("S_REMARK >=", value, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkLessThan(String value) {
			addCriterion("S_REMARK <", value, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkLessThanOrEqualTo(String value) {
			addCriterion("S_REMARK <=", value, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkLike(String value) {
			addCriterion("S_REMARK like", value, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkNotLike(String value) {
			addCriterion("S_REMARK not like", value, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkIn(List<String> values) {
			addCriterion("S_REMARK in", values, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkNotIn(List<String> values) {
			addCriterion("S_REMARK not in", values, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkBetween(String value1, String value2) {
			addCriterion("S_REMARK between", value1, value2, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSRemarkNotBetween(String value1, String value2) {
			addCriterion("S_REMARK not between", value1, value2, "sRemark");
			return (Criteria) this;
		}

		public Criteria andSIseffectIsNull() {
			addCriterion("S_ISEFFECT is null");
			return (Criteria) this;
		}

		public Criteria andSIseffectIsNotNull() {
			addCriterion("S_ISEFFECT is not null");
			return (Criteria) this;
		}

		public Criteria andSIseffectEqualTo(String value) {
			addCriterion("S_ISEFFECT =", value, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectNotEqualTo(String value) {
			addCriterion("S_ISEFFECT <>", value, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectGreaterThan(String value) {
			addCriterion("S_ISEFFECT >", value, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectGreaterThanOrEqualTo(String value) {
			addCriterion("S_ISEFFECT >=", value, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectLessThan(String value) {
			addCriterion("S_ISEFFECT <", value, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectLessThanOrEqualTo(String value) {
			addCriterion("S_ISEFFECT <=", value, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectLike(String value) {
			addCriterion("S_ISEFFECT like", value, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectNotLike(String value) {
			addCriterion("S_ISEFFECT not like", value, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectIn(List<String> values) {
			addCriterion("S_ISEFFECT in", values, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectNotIn(List<String> values) {
			addCriterion("S_ISEFFECT not in", values, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectBetween(String value1, String value2) {
			addCriterion("S_ISEFFECT between", value1, value2, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andSIseffectNotBetween(String value1, String value2) {
			addCriterion("S_ISEFFECT not between", value1, value2, "sIseffect");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateIsNull() {
			addCriterion("TS_SYSUPDATE is null");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateIsNotNull() {
			addCriterion("TS_SYSUPDATE is not null");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateEqualTo(Date value) {
			addCriterion("TS_SYSUPDATE =", value, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateNotEqualTo(Date value) {
			addCriterion("TS_SYSUPDATE <>", value, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateGreaterThan(Date value) {
			addCriterion("TS_SYSUPDATE >", value, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateGreaterThanOrEqualTo(Date value) {
			addCriterion("TS_SYSUPDATE >=", value, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateLessThan(Date value) {
			addCriterion("TS_SYSUPDATE <", value, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateLessThanOrEqualTo(Date value) {
			addCriterion("TS_SYSUPDATE <=", value, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateIn(List<Date> values) {
			addCriterion("TS_SYSUPDATE in", values, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateNotIn(List<Date> values) {
			addCriterion("TS_SYSUPDATE not in", values, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateBetween(Date value1, Date value2) {
			addCriterion("TS_SYSUPDATE between", value1, value2, "tsSysupdate");
			return (Criteria) this;
		}

		public Criteria andTsSysupdateNotBetween(Date value1, Date value2) {
			addCriterion("TS_SYSUPDATE not between", value1, value2,
					"tsSysupdate");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table TM_MSINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TM_MSINFO
     *
     * @mbggenerated do_not_delete_during_merge Mon May 18 09:26:27 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}