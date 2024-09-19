package com.zyz.basic.core.util;


import com.zyz.basic.core.bean.GuestDb;
import com.zyz.basic.core.bean.MasterDb;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

/**
 * 数据库对比
 *
 * @author wd
 * @date 2022-06-08 15:02
 **/
@Component
public class DbCompareUtil {

	@Autowired
	private MasterDb testDb;

	@Autowired
	private GuestDb prodDb;

	private static String handTable(String table) {
		return table.replaceAll("AUTO_INCREMENT=\\d+", "").trim();
	}

	public static String getCompareStr(String char1, String char2) {
		String color = "<span style='background-color:yellow;color:red;'>";
		String color1 = "</span>";
		StringBuilder sb = new StringBuilder();
		char[] a = new char[char1.length()];
		for (int i = 0; i < char1.length(); i++) {
			a[i] = char1.charAt(i);
		}
		char[] b = new char[char2.length()];
		for (int i = 0; i < char2.length(); i++) {
			b[i] = char2.charAt(i);
		}
		Map<Object, Object> map1 = new HashMap<>();
		// 包含字符集合
		Map<Object, Object> map2 = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1) {
				if (i > 1) {
					if (String.valueOf(b).contains(String.valueOf(a[i - 1]) + a[i])) {
						map2.put(i - 1, a[i - 1]);
						map2.put(i, a[i]);
					} else {
						map1.put(i, a[i]);
					}
				} else {
					map2.put(i, a[i]);
				}
			} else {
				if (String.valueOf(b).contains(String.valueOf(a[i]) + a[i + 1])) {
					if (i > 1) {
						if (String.valueOf(b).contains(String.valueOf(a[i - 1]) + a[i])) {
							map2.put(i - 1, a[i - 1]);
							map2.put(i, a[i]);
						}
					} else {
						map2.put(i, a[i]);
					}
				} else {
					if (i > 0) {
						if (String.valueOf(b).contains(String.valueOf(a[i - 1]) + a[i])) {
							map2.put(i - 1, a[i - 1]);
							map2.put(i, a[i]);
						} else {
							map1.put(i, a[i]);
						}
					} else {
						map1.put(i, a[i]);
					}
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (map1.get(i) != null) {
				sb.append(color).append(map1.get(i)).append(color1);
			} else if (map2.get(i) != null) {
				sb.append(map2.get(i));
			}
		}
		return sb.toString();
	}

	public void compared() throws IOException {
		//需要比对的数据库名,多个逗号连接
		String dbs = "tfdb";
		String tableSql = "select table_name,table_comment FROM information_schema.tables WHERE table_schema=?";
		//忽略比对的表名,多个逗号连接  支持正则
		String ignoreTable = "|(msg_log_\\w+)|(hand_log_\\w+)|(act_\\w+)";
		List<Map<String, Object>> tableDiffList = new ArrayList<>();
		Map<String, Object> diffMap;
		Map<String, Integer> dbTableCountMap = new HashMap<>();
		int dbTableCount = 0;
		for (String db : dbs.split(",")) {
			dbTableCount = 0;
			List<Map<String, Object>> tables = testDb.getTables();
			for (Map<String, Object> stringObjectMap : tables) {
				String table = stringObjectMap.get("table_name").toString();
				if (table.matches(ignoreTable)) {
					continue;
				}
				diffMap = new HashMap<>();
				Map<String, Object> sourceTableMap = testDb.sourceTableMap(table);
				String sourceTable = handTable(MapUtils.getString(sourceTableMap, "Create Table"));
				diffMap.put("tableName", table);
				diffMap.put("dbName", db);
				diffMap.put("sourceTable", sourceTable);
				Map<String, Object> targetTableMap;
				try {
					targetTableMap = prodDb.sourceTableMap(table);
				} catch (Exception e) {
					dbTableCount = dbTableCount + 1;
					diffMap.put("targetTable", "不存在");
					tableDiffList.add(diffMap);
					continue;
				}
				String targetTable = handTable(MapUtils.getString(targetTableMap, "Create Table"));
				if (sourceTable.equals(targetTable)) {
					continue;
				}

				diffMap.put("targetTableStruct", targetTable);
				diffMap.put("sourceTableStruct", sourceTable);

				diffMap.put("targetTable", getCompareStr(targetTable, sourceTable));
				diffMap.put("sourceTable", getCompareStr(sourceTable, targetTable));
				tableDiffList.add(diffMap);
				dbTableCount = dbTableCount + 1;

			}
			dbTableCountMap.put(db, dbTableCount);
		}
		StringJoiner html = new StringJoiner("\n");
		html.add("<table style=\"font-size:12px;color:#333333;width:100%;border-width: 1px;border-color: #729ea5;border-collapse: collapse;\" border=\"1\">\n" +
				"<tr><th >数据库名</th><th>源表</th><th>对比表</th></tr>");

		for (Map<String, Object> m : tableDiffList) {
			String dbName = m.get("dbName").toString();
			Integer dbTabeCount = dbTableCountMap.get(dbName);
			if (dbTabeCount != null) {
				html.add("<tr> <td rowspan=\"" + dbTabeCount + "\">" + dbName + "</td>");
				dbTableCountMap.remove(dbName);
			}
			html.add("<td>\n" +
					"<pre> " + m.get("sourceTable").toString() + " <pre>\n" +
					"</td>");
			html.add("<td>\n" +
					"<pre> " + m.get("targetTable").toString() + " <pre>\n" +
					"</td>");
			html.add("</tr>");
		}
		html.add("</table>");
		FileUtils.writeStringToFile(new File("D:\\DbCompared.html"), html.toString(), "utf-8");

		StringJoiner html2 = new StringJoiner("\n");
		for (Map<String, Object> m : tableDiffList) {
			String targetTable = m.get("targetTable").toString();
			if ("不存在".equals(targetTable)) {
				html2.add(m.get("sourceTable").toString() + ";");
				html2.add("\n");
			}
		}

		for (Map<String, Object> m : tableDiffList) {
			String targetTable = m.get("targetTable").toString();
			if (!"不存在".equals(targetTable)) {
				String tableName = m.get("tableName").toString();
				List<String> sourceTableColums = testDb.getTableColumns(tableName);
				List<String> targetTableColums = prodDb.getTableColumns(tableName);

				Map<String, Object> sourceTableColumsMap = new HashMap<>(16);
				Map<String, Object> targetTableColumsMap = new HashMap<>(16);

				sourceTableColums.forEach(s -> {
					String[] split = s.split(",");
					sourceTableColumsMap.put(split[0], split[1]);
				});
				targetTableColums.forEach(s -> {
					String[] split = s.split(",");
					targetTableColumsMap.put(split[0], split[1]);
				});

				Set<String> sourceSet = sourceTableColumsMap.keySet();
				Set<String> targetSet = targetTableColumsMap.keySet();

				List<String> addColumns = new ArrayList<>();
				List<String> updateColumns = new ArrayList<>();
				for (String str : sourceSet) {
					if (!targetSet.contains(str)) {
						addColumns.add(str);
						continue;
					}
					String sType = ObjectUtils.isEmpty(sourceTableColumsMap.get(str)) ? "" : sourceTableColumsMap.get(str).toString();
					String tType = ObjectUtils.isEmpty(targetTableColumsMap.get(str)) ? "" : targetTableColumsMap.get(str).toString();
					if (!sType.equals(tType)) {
						updateColumns.add(str);
					}
				}
				String sourceTableStruct = m.get("sourceTableStruct").toString().replaceAll("\\\\s*|\\t|\\r|\\n", "");
				Matcher matcher = compile("\\(").matcher(sourceTableStruct);
				int start = 0;
				if (matcher.find()) {
					start = matcher.start();
				}
				int end = sourceTableStruct.lastIndexOf(")");
				String[] tableSQLs = sourceTableStruct.substring(start + 1, end).trim().split(", {2}");
				List<String> sqlList = new ArrayList<>();
				for (String sql : tableSQLs) {
					String trim = sql.trim().replaceAll("`", "");
					sqlList.add(trim);
				}

				for (String columns : addColumns) {
					for (String sql : sqlList) {
						if (sql.startsWith(columns)) {
							html2.add("alter table " + tableName + " add column " + sql + ";");
							html2.add("\n");
							break;
						}
					}
				}

				for (String columns : updateColumns) {
					for (String sql : sqlList) {
						if (sql.startsWith(columns)) {
							html2.add("alter table " + tableName + " modify column " + sql + ";");
							html2.add("\n");
							break;
						}
					}
				}

			}
		}
		FileUtils.writeStringToFile(new File("D:\\DbCompared.sql"), html2.toString(), "utf-8");
	}
}
