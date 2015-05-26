package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.TmChrinfodetail;
import com.aisino.finace.account.entity.TmChrinfodetailExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmChrinfodetailMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int countByExample(TmChrinfodetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int deleteByExample(TmChrinfodetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int deleteByPrimaryKey(BigDecimal iCardid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int insert(TmChrinfodetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int insertSelective(TmChrinfodetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	List<TmChrinfodetail> selectByExample(TmChrinfodetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	TmChrinfodetail selectByPrimaryKey(BigDecimal iCardid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int updateByExampleSelective(@Param("record") TmChrinfodetail record,
			@Param("example") TmChrinfodetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int updateByExample(@Param("record") TmChrinfodetail record,
			@Param("example") TmChrinfodetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int updateByPrimaryKeySelective(TmChrinfodetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_CHRINFODETAIL
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int updateByPrimaryKey(TmChrinfodetail record);
}