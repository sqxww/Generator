package com.sqxww.generator.main;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.sqxww.generator.entity.Table;
import com.sqxww.generator.utils.FileUtil;
import com.sqxww.generator.utils.FreeMarkerUtil;
import com.sqxww.generator.utils.TableUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;


public class HrzGenerator {
	private static Table table = null;
	public static void generateMapper() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_mapXml.ftl");
		String mapPck = table.getPackName() + ".mapping";
		String path = FileUtil.newMapPackage(mapPck);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getEntityName() + ".map.xml"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	public static void generateAddDoc() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_adddoc.ftl");
		String mapPck = table.getPackName() + ".doc";
		String path = FileUtil.newPackage(mapPck);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getEntityName() + "添加.txt"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateUpdateDoc() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_updatedoc.ftl");
		String mapPck = table.getPackName() + ".doc";
		String path = FileUtil.newPackage(mapPck);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getEntityName() + "更新.txt"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateListDoc() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_listdoc.ftl");
		String mapPck = table.getPackName() + ".doc";
		String path = FileUtil.newPackage(mapPck);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getEntityName() + "列表.txt"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateGetDoc() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_getdoc.ftl");
		String mapPck = table.getPackName() + ".doc";
		String path = FileUtil.newPackage(mapPck);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getEntityName() + "获取.txt"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateDelDoc() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_deldoc.ftl");
		String mapPck = table.getPackName() + ".doc";
		String path = FileUtil.newPackage(mapPck);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getEntityName() + "删除.txt"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateDao() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_dao.ftl");
		String pack = table.getPackName() + ".service.dao";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "Dao.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateDaoImpl() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_daoImpl.ftl");
		String pack = table.getPackName() + ".service.dao.impl";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "DaoImpl.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateRepository() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_repository.ftl");
		String pack = table.getPackName() + ".repository";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "Repository.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateRepositoryImpl() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_repositoryImpl.ftl");
		String pack = table.getPackName() + ".repository.impl";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "RepositoryImpl.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateFacade() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_facade.ftl");
		String pack = table.getPackName() + ".service";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "Facade.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateFacadeImpl() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_facadeImpl.ftl");
		String pack = table.getPackName() + ".service.impl";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "FacadeImpl.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateController() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_controller.ftl");
		String pack = table.getPackName() + ".web.controller";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "Controller.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	public static void generateResult() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_result.ftl");
		String pack = table.getPackName() + ".view";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "APIResult.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	public static void generateDomain() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		table.setPackName(FileUtil.getValue("facadePack"));
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("hrz_domain.ftl");
		String pack = table.getPackName() + ".domain";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "Domain.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) throws Exception {
		generateMapper();
		generateDao();
		generateDaoImpl();
		generateRepository();
		generateRepositoryImpl();
		generateFacade();
		generateFacadeImpl();
		generateController();
		generateResult();
		generateDomain();
		generateAddDoc();
		generateDelDoc();
		generateGetDoc();
		generateListDoc();
		generateUpdateDoc();
	}
}
