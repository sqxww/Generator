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

public class Generator {
	
	private static Table table = null;
	
	public static void generateMapper() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("mapXml.ftl");
		String mapPck = table.getPackName() + ".persistence.mapping";
		String path = FileUtil.newMapPackage(mapPck);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getEntityName() + ".map.xml"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateController() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("controller.ftl");
		String conPck = table.getConPack();
		String conPath = FileUtil.newPackage(conPck);
		Writer conOut = new OutputStreamWriter(new FileOutputStream(conPath + table.getClassName() + "Controller.java"));
		template.process(table, conOut);
		conOut.flush();
		conOut.close();
	}
	
	public static void generateDao() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("dao.ftl");
		String pack = table.getPackName() + ".persistence.dao";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "Dao.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateDaoImpl() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("daoImpl.ftl");
		String pack = table.getPackName() + ".persistence.dao.impl";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "DaoImpl.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateQueryDao() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("queryDao.ftl");
		String pack = table.getPackName() + ".persistence.dao";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "QueryDao.java"));
		template.process(table, out);
		out.flush();
		out.close();		
	}

	public static void generateQueryDaoImpl() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("queryDaoImpl.ftl");
		String pack = table.getPackName() + ".persistence.dao.impl";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "QueryDaoImpl.java"));
		template.process(table, out);
		out.flush();
		out.close();		
	}

	public static void generateRepository() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("repository.ftl");
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
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("repositoryImpl.ftl");
		String pack = table.getPackName() + ".repository.impl";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "RepositoryImpl.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generatePo() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("po.ftl");
		String pack = table.getPackName() + ".persistence.entity";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "Po.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateTbl() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("tbl.ftl");
		String pack = table.getPackName() + ".persistence.entity";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + "Tbl.java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
	public static void generateDomain() throws Exception{
		if(null == table)
			table = TableUtil.getTable(FileUtil.getTablename());
		Configuration configuration = FreeMarkerUtil.getConfiguration();
		Template template = configuration.getTemplate("domain.ftl");
		String pack = table.getPackName() + ".domain";
		String path = FileUtil.newPackage(pack);
		Writer out = new OutputStreamWriter(new FileOutputStream(path + table.getClassName() + ".java"));
		template.process(table, out);
		out.flush();
		out.close();
	}
	
}
