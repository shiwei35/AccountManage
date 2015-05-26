package com.aisino.finace.account.dao;

import com.aisino.finace.account.entity.TmMerinfo;
import com.aisino.finace.account.entity.TmMerinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmMerinfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int countByExample(TmMerinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int deleteByExample(TmMerinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int deleteByPrimaryKey(Long iMercode);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int insert(TmMerinfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int insertSelective(TmMerinfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	List<TmMerinfo> selectByExample(TmMerinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	TmMerinfo selectByPrimaryKey(Long iMercode);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int updateByExampleSelective(@Param("record") TmMerinfo record,
			@Param("example") TmMerinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int updateByExample(@Param("record") TmMerinfo record,
			@Param("example") TmMerinfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int updateByPrimaryKeySelective(TmMerinfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TM_MERINFO
	 * @mbggenerated  Thu May 21 17:25:15 CST 2015
	 */
	int updateByPrimaryKey(TmMerinfo record);
}