/**
 * 
 */
package com.aisino.finace.account.utils.key;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 
 */
@Repository
@Transactional
public class KeyDao {

	private static final String TABLE = "ML_SYS_KEY";
	private static final String MAX_KEY_VALUE = "KEY_VALUE";
	private static final String COLS_TABLE_NAME = "TABLE_NAME";
	private static final String COLS_TABLE_KEY_NAME = "KEY_NAME";

	private JdbcTemplate jdbcTemplate;

	private static final String updateKeySQL = "update " + TABLE + " set "
			+ MAX_KEY_VALUE + "=" + MAX_KEY_VALUE + "+" + KeyPool.getPoolSize()
			+ " where " + COLS_TABLE_NAME + " = ?";

	private static final String getTableAndKeyName = "select "
			+ COLS_TABLE_NAME + ", " + COLS_TABLE_KEY_NAME + " from " + TABLE
			+ " where " + COLS_TABLE_NAME + " = ?";

	private static final String selectKeySQL = "select " + MAX_KEY_VALUE
			+ " from " + TABLE + " where " + COLS_TABLE_NAME + " = ?";

	private static final String testExistSQL = "select count(*) from " + TABLE
			+ " where " + COLS_TABLE_NAME + " = ?";

	private static final String insertSQL = "insert into " + TABLE
			+ " (KEY_VALUE, TABLE_NAME, KEY_NAME) values(?, ?, ?)";

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional(rollbackFor = Exception.class)
	public void initKeyPool(final KeyPool keyPool) {
		// 首先做查询，表存不存在

		// String updateSQL =
		// "update key_table set max_keyValue = max_keyValue + "+KeyPool.getPoolSize()
		// + "where keyName = ?";
		// 更新数据库中的key记录，主要是key的键值要增加
		// jdbcTemplate.update("update key_table set max_keyValue = max_keyValue + "+KeyPool.getPoolSize()
		// + "where keyName = ?");
		if (keyPool.getMaxValue() == null) {
			queryAndInit(keyPool);
		}
		jdbcTemplate.update(updateKeySQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, keyPool.getTableName());
			}
		});
		jdbcTemplate.queryForObject(selectKeySQL,
				new Object[] { keyPool.getTableName() },
				new RowMapper<KeyPool>() {
					@Override
					public KeyPool mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						keyPool.setMaxValue(new AtomicLong(rs
								.getLong(MAX_KEY_VALUE)));
						keyPool.setNextValue(new AtomicLong(
								getCurrentValue(keyPool) + 1));
						return keyPool;
					}
				});
	}

	private void queryAndInit(final KeyPool keyPool) {
		Long count = jdbcTemplate.queryForObject(testExistSQL,
				new Object[] { keyPool.getTableName() }, Long.class);
		if (count.longValue() == 0) {
			insert(keyPool);
		}
	}

	private void insert(final KeyPool keyPool) {
		jdbcTemplate.update(insertSQL, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, getCurrentValue(keyPool) + KeyPool.getPoolSize());
				ps.setString(2, keyPool.getTableName());
				ps.setString(3, keyPool.getTableKeyName());
			}
		});
	}

	private Long getCurrentValue(final KeyPool keyPool) {
		/*
		 * jdbcTemplate.query(getTableAndKeyName, new
		 * Object[]{keyPool.getTableName().toLowerCase()}, new
		 * RowMapper<KeyPool>() {
		 * 
		 * @Override public KeyPool mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { keyPool.setTableName(rs.getString(COLS_TABLE_NAME));
		 * keyPool.setTableKeyName(rs.getString(COLS_TABLE_KEY_NAME)); return
		 * keyPool; } });
		 */

		String sql = "select max(" + keyPool.getTableKeyName() + ") from "
				+ keyPool.getTableName();
		Long currentValue = jdbcTemplate.queryForObject(sql, Long.class);
		currentValue = currentValue == null ? 0L : currentValue;
		return currentValue;
	}
}
