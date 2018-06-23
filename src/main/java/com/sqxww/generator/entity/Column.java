package com.sqxww.generator.entity;

import java.sql.Types;

import com.sqxww.generator.utils.NameUtil;

public class Column {
	private String columnName;
	private String fieldName;
	private String jdbcType;
	private String javaType;
	private String remarks;
	private String docType;
	private int type;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
		this.fieldName = NameUtil.delUnderLine(columnName);
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getJdbcType() {
		return jdbcType;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
/*		switch (type) {
		case Types.ARRAY:
			jdbcType = "ARRAY";
			javaType = "java.sql.Array";
			break;
		case Types.BIGINT:
			jdbcType = "BIGINT";
			javaType = "java.math.BigInteger";
			break;
		case Types.BINARY:
			jdbcType = "BINARY";
			javaType = "java.lang.Byte[]";
			break;
		case Types.BIT:
			jdbcType = "BIT";
			javaType = "java.lang.Boolean";
			break;
		case Types.BLOB:
			jdbcType = "BLOB";
			javaType = "java.lang.Byte[]";
			break;
		case Types.BOOLEAN:
			jdbcType = "BOOLEAN";
			javaType = "java.lang.short";
			break;
		case Types.CHAR:
			jdbcType = "CHAR";
			javaType ="java.lang.String";
			break;
		case Types.CLOB:
			jdbcType = "CLOB";
			javaType = "java.lang.String";
			break;
		case Types.DATALINK:
			jdbcType = "DATALINK";
			javaType = "java.net.URL";
			break;
		case Types.DATE:
			jdbcType = "DATE";
			javaType = "java.util.Date";
			break;
		case Types.DECIMAL:
			jdbcType = "DECIMAL";
			javaType = "java.math.BigDecimal";
			break;
		case Types.DISTINCT:
			jdbcType = "DISTINCT";
			break;
		case Types.DOUBLE:
			jdbcType = "DOUBLE";
			javaType="java.lang.Double";
			break;
		case Types.FLOAT:
			jdbcType = "FLOAT";
			javaType = "java.lang.Float";
			break;
		case Types.INTEGER:
			jdbcType = "INTEGER";
			javaType = "java.lang.Integer";
			break;
		case Types.JAVA_OBJECT:
			jdbcType = "JAVA_OBJECT";
			break;
		case Types.LONGNVARCHAR:
			jdbcType = "LONGNVARCHAR";
			javaType = "java.lang.String";
			break;
		case Types.LONGVARBINARY:
			jdbcType = "LONGVARBINARY";
			javaType = "java.lang.String";
			break;
		case Types.LONGVARCHAR:
			jdbcType = "LONGVARCHAR";
			javaType = "java.lang.String";
			break;
		case Types.NCHAR:
			jdbcType = "NCHAR";
			javaType = "java.lang.String";
			break;
		case Types.NCLOB:
			jdbcType = "NCLOB";
			javaType = "java.lang.String";
			break;
		case Types.NULL:
			jdbcType = "NULL";
			break;
		case Types.NUMERIC:
			jdbcType = "NUMERIC";
			javaType = "java.math.BigDecimal";
			break;
		case Types.NVARCHAR:
			jdbcType = "NVARCHAR";
			javaType = "java.lang.String";
			break;
		case Types.OTHER:
			jdbcType = "OTHER";
			break;
		case Types.REAL:
			jdbcType = "REAL";
			break;
		case Types.REF:
			jdbcType = "REF";
			break;
		case Types.ROWID:
			jdbcType = "ROWID";
			javaType = "java.lang.Integer";
			break;
		case Types.SMALLINT:
			jdbcType = "SMALLINT";
			javaType = "java.lang.Integer";
			break;
		case Types.SQLXML:
			jdbcType = "SQLXML";
			javaType = "java.lang.String";
			break;
		case Types.STRUCT:
			jdbcType = "STRUCT";
			break;
		case Types.TIME:
			jdbcType = "TIME";
			javaType = "java.util.Date";
			break;
		case Types.TIMESTAMP:
			jdbcType = "TIMESTAMP";
			javaType = "java.util.Date";
			break;
		case Types.TINYINT:
			jdbcType = "TINYINT";
			javaType = "java.lang.Integer";
			break;
		case Types.VARBINARY:
			jdbcType = "VARBINARY";
			javaType = "java.lang.Byte[]";
			break;
		case Types.VARCHAR:
			jdbcType = "VARCHAR";
			javaType = "java.lang.String";
			break;

		default:
			break;
		}*/
	}
	
	public String getJavaType(){
		return this.javaType;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
		if("VARCHAR".equals(jdbcType) || "CHAR".equals(jdbcType)){
			this.docType = "string";
		}else if ("INT".equals(jdbcType) || "TINYINT".equals(jdbcType)) {
			this.docType = "int";
		}else if("TIMESTAMP".equals(jdbcType) || "TIME".equals(jdbcType) || "DATE".equals(jdbcType) || "DATETIME".equals(jdbcType)) {
			this.docType = "long";
		}else {
			this.docType = "string";
		}
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
}
