package com.aisino.finace.account.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TmMerinfo {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.I_MERCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private Long iMercode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_ORGUUID
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sOrguuid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_MERNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sMername;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_MERSTATUS
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sMerstatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.D_MEREXPDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private Date dMerexpdate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_CITYCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sCitycode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_CITYNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sCityname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_MERCONTNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sMercontname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_MERCONTPHONE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sMercontphone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_MERADDR
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sMeraddr;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_MERZIP
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sMerzip;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_EMAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sEmail;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_UPPEMERCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sUppemercode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.D_ACCTREGDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private Date dAcctregdate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_REMARK
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sRemark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.S_ISEFFECT
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private String sIseffect;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column TM_MERINFO.TS_SYSUPDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	private Date tsSysupdate;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.I_MERCODE
	 * @return  the value of TM_MERINFO.I_MERCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public Long getiMercode() {
		return iMercode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.I_MERCODE
	 * @param iMercode  the value for TM_MERINFO.I_MERCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setiMercode(Long iMercode) {
		this.iMercode = iMercode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_ORGUUID
	 * @return  the value of TM_MERINFO.S_ORGUUID
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsOrguuid() {
		return sOrguuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_ORGUUID
	 * @param sOrguuid  the value for TM_MERINFO.S_ORGUUID
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsOrguuid(String sOrguuid) {
		this.sOrguuid = sOrguuid == null ? null : sOrguuid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_MERNAME
	 * @return  the value of TM_MERINFO.S_MERNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsMername() {
		return sMername;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_MERNAME
	 * @param sMername  the value for TM_MERINFO.S_MERNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsMername(String sMername) {
		this.sMername = sMername == null ? null : sMername.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_MERSTATUS
	 * @return  the value of TM_MERINFO.S_MERSTATUS
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsMerstatus() {
		return sMerstatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_MERSTATUS
	 * @param sMerstatus  the value for TM_MERINFO.S_MERSTATUS
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsMerstatus(String sMerstatus) {
		this.sMerstatus = sMerstatus == null ? null : sMerstatus.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.D_MEREXPDATE
	 * @return  the value of TM_MERINFO.D_MEREXPDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public Date getdMerexpdate() {
		return dMerexpdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.D_MEREXPDATE
	 * @param dMerexpdate  the value for TM_MERINFO.D_MEREXPDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setdMerexpdate(Date dMerexpdate) {
		this.dMerexpdate = dMerexpdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_CITYCODE
	 * @return  the value of TM_MERINFO.S_CITYCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsCitycode() {
		return sCitycode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_CITYCODE
	 * @param sCitycode  the value for TM_MERINFO.S_CITYCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsCitycode(String sCitycode) {
		this.sCitycode = sCitycode == null ? null : sCitycode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_CITYNAME
	 * @return  the value of TM_MERINFO.S_CITYNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsCityname() {
		return sCityname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_CITYNAME
	 * @param sCityname  the value for TM_MERINFO.S_CITYNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsCityname(String sCityname) {
		this.sCityname = sCityname == null ? null : sCityname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_MERCONTNAME
	 * @return  the value of TM_MERINFO.S_MERCONTNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsMercontname() {
		return sMercontname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_MERCONTNAME
	 * @param sMercontname  the value for TM_MERINFO.S_MERCONTNAME
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsMercontname(String sMercontname) {
		this.sMercontname = sMercontname == null ? null : sMercontname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_MERCONTPHONE
	 * @return  the value of TM_MERINFO.S_MERCONTPHONE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsMercontphone() {
		return sMercontphone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_MERCONTPHONE
	 * @param sMercontphone  the value for TM_MERINFO.S_MERCONTPHONE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsMercontphone(String sMercontphone) {
		this.sMercontphone = sMercontphone == null ? null : sMercontphone
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_MERADDR
	 * @return  the value of TM_MERINFO.S_MERADDR
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsMeraddr() {
		return sMeraddr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_MERADDR
	 * @param sMeraddr  the value for TM_MERINFO.S_MERADDR
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsMeraddr(String sMeraddr) {
		this.sMeraddr = sMeraddr == null ? null : sMeraddr.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_MERZIP
	 * @return  the value of TM_MERINFO.S_MERZIP
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsMerzip() {
		return sMerzip;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_MERZIP
	 * @param sMerzip  the value for TM_MERINFO.S_MERZIP
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsMerzip(String sMerzip) {
		this.sMerzip = sMerzip == null ? null : sMerzip.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_EMAIL
	 * @return  the value of TM_MERINFO.S_EMAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsEmail() {
		return sEmail;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_EMAIL
	 * @param sEmail  the value for TM_MERINFO.S_EMAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail == null ? null : sEmail.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_UPPEMERCODE
	 * @return  the value of TM_MERINFO.S_UPPEMERCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsUppemercode() {
		return sUppemercode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_UPPEMERCODE
	 * @param sUppemercode  the value for TM_MERINFO.S_UPPEMERCODE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsUppemercode(String sUppemercode) {
		this.sUppemercode = sUppemercode == null ? null : sUppemercode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.D_ACCTREGDATE
	 * @return  the value of TM_MERINFO.D_ACCTREGDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public Date getdAcctregdate() {
		return dAcctregdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.D_ACCTREGDATE
	 * @param dAcctregdate  the value for TM_MERINFO.D_ACCTREGDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setdAcctregdate(Date dAcctregdate) {
		this.dAcctregdate = dAcctregdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_REMARK
	 * @return  the value of TM_MERINFO.S_REMARK
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsRemark() {
		return sRemark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_REMARK
	 * @param sRemark  the value for TM_MERINFO.S_REMARK
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsRemark(String sRemark) {
		this.sRemark = sRemark == null ? null : sRemark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.S_ISEFFECT
	 * @return  the value of TM_MERINFO.S_ISEFFECT
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public String getsIseffect() {
		return sIseffect;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.S_ISEFFECT
	 * @param sIseffect  the value for TM_MERINFO.S_ISEFFECT
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setsIseffect(String sIseffect) {
		this.sIseffect = sIseffect == null ? null : sIseffect.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column TM_MERINFO.TS_SYSUPDATE
	 * @return  the value of TM_MERINFO.TS_SYSUPDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public Date getTsSysupdate() {
		return tsSysupdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column TM_MERINFO.TS_SYSUPDATE
	 * @param tsSysupdate  the value for TM_MERINFO.TS_SYSUPDATE
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	public void setTsSysupdate(Date tsSysupdate) {
		this.tsSysupdate = tsSysupdate;
	}
}