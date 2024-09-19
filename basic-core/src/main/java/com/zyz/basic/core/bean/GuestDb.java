package com.zyz.basic.core.bean;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客数据库
 *
 * @author 张易筑
 * @date 2024-09-19 15:22:03
 */
@Service
@DS("guest")
public class GuestDb {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_SQL = " SELECT table_name, table_comment FROM information_schema.tables WHERE table_schema = 'rbms_demo' ";

    private static final String tableCreateSql = " SHOW CREATE TABLE ";

	private static final String GET_TABLE_COLUMNS = " SELECT CONCAT(column_name, ',' ,COLUMN_type) column_name FROM information_schema.COLUMNS WHERE `TABLE_SCHEMA` = 'rbms_demo' AND `TABLE_NAME` = ";

	public List<Map<String, Object>> getTables() {
		return jdbcTemplate.queryForList(TABLE_SQL);
	}

	public Map<String, Object> sourceTableMap(String table) {
		return jdbcTemplate.queryForMap(tableCreateSql + table);
	}

	public List<String> getTableColumns(String table) {
		return jdbcTemplate.queryForList(GET_TABLE_COLUMNS + "'" + table + "'", String.class);
	}
}
