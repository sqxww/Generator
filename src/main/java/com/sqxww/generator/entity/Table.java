package com.sqxww.generator.entity;

import java.util.List;

import com.sqxww.generator.utils.FileUtil;
import com.sqxww.generator.utils.NameUtil;

public class Table {
	private String tableName;	//表名(全小写)
	private String className;	//表对应的domain类名
	private String entityName;	//表对应的domain对象名
	private String remarks;
	private List<Column> columns;
	private String packName = FileUtil.getPackagename();
	private String conPack = FileUtil.getConpackagename();
	private String tips = FileUtil.getValue("tips");
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName.toLowerCase();
		String temp = this.tableName;
		//去掉表名开头
		if("true".equals(FileUtil.getValue("delFirst")))
			temp = this.tableName.substring(this.tableName.indexOf('_') + 1);
		this.entityName = NameUtil.delUnderLine(temp);
		this.className = NameUtil.firstToUp(entityName);
	}
	public String getClassName() {
		return className;
	}
	public String getEntityName() {
		return entityName;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public String getPackName() {
		return packName;
	}
	public String getConPack() {
		return conPack;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
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
	
}
