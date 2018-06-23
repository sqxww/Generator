package com.sqxww.generator.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sqxww.generator.entity.Column;
import com.sqxww.generator.entity.Table;

public class TableUtil {
	
	private static Connection con = null;
	
	public static Table getTable(String tableName) throws SQLException{
		if(null == con || con.isClosed())
			con = JdbcUtil.getConnection();
		DatabaseMetaData dmd = con.getMetaData();
		ResultSet tableSet =  dmd.getTables(null, "%", tableName, new String[] { "TABLE" });
		
		
		Table table = new Table();
		while(tableSet.next()){
			String temp = tableSet.getString("TABLE_NAME");
			if(temp.equals(tableName)){
				table.setTableName(tableName);
				String tableRemarks = tableSet.getString("REMARKS");
				table.setRemarks(tableRemarks);
				ResultSet columnSet = con.getMetaData().getColumns(null, "%",temp.toUpperCase(), "%");
				List<Column> columns = new ArrayList<Column>();
				while (columnSet.next()) {
					Column column = new Column();
					String columnName = columnSet.getString("COLUMN_NAME");
					String remarks = columnSet.getString("REMARKS");
					String jdbcType = columnSet.getString("TYPE_NAME");
					column.setColumnName(columnName);
					column.setRemarks(remarks);
					column.setJdbcType(jdbcType);
					columns.add(column);
				}
				table.setColumns(columns);
			}
		}
		
//		ResultSet r = s.executeQuery("select * from " + tableName + " where 1=2");
//		ResultSetMetaData rsmd = r.getMetaData();
//		List<Column> columns = new ArrayList<Column>();
//		for(int i = 1; i <= rsmd.getColumnCount(); i++){
//			Column column = new Column();
//			column.setColumnName(rsmd.getColumnName(i));
//			column.setType(rsmd.getColumnType(i));
//			columns.add(column);
//		}
//		table.setColumns(columns);
//		JdbcUtil.close(con, r, s, null);
		return table;
	}
	
	public static void main(String[] args) throws Exception {
		getTable("order_promote");
	}
	
}
