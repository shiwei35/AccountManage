package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.TcIssuserchkacct;
import com.aisino.finace.account.entity.TcIssuserchkacctExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TcIssuserchkacctMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int countByExample(TcIssuserchkacctExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int deleteByExample(TcIssuserchkacctExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int deleteByPrimaryKey(BigDecimal iIssuerchkseq);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int insert(TcIssuserchkacct record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int insertSelective(TcIssuserchkacct record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	List<TcIssuserchkacct> selectByExample(TcIssuserchkacctExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	TcIssuserchkacct selectByPrimaryKey(BigDecimal iIssuerchkseq);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int updateByExampleSelective(@Param("record") TcIssuserchkacct record,
			@Param("example") TcIssuserchkacctExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int updateByExample(@Param("record") TcIssuserchkacct record,
			@Param("example") TcIssuserchkacctExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int updateByPrimaryKeySelective(TcIssuserchkacct record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TC_ISSUSERCHKACCT
	 * @mbggenerated  Sat May 16 12:16:44 CST 2015
	 */
	int updateByPrimaryKey(TcIssuserchkacct record);
}