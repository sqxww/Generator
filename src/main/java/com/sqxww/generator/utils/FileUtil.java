package com.sqxww.generator.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	private static final String TABLENAME;
	private static final String PACKAGENAME;
	private static final String CONPACKAGENAME;

	private static final String DOMAINO;
	private static Properties properties;
	static{
		properties = new Properties();
		try {
			properties.load(FileUtil.class.getClassLoader().getResourceAsStream("conf/args.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		TABLENAME = properties.getProperty("tableName");
		PACKAGENAME = properties.getProperty("package");
		CONPACKAGENAME = properties.getProperty("controllerPackage");
		DOMAINO = NameUtil.delUnderLine(TABLENAME);
	}
	
	/**
	 * 创建包
	 */
	public static String newPackage(String packageName){
		if(null != packageName && !"".equals(packageName)){
			String path = getSrcPath("maven") + NameUtil.packToPath(packageName);
			File temp = new File(path);
			temp.mkdirs();
			return path;
		}
		return null;
	}
	
	/**
	 * 创建包
	 */
	public static String newMapPackage(String packageName){
		if(null != packageName && !"".equals(packageName)){
			String path = getProjectPath("maven") +"src/main/resources/" + NameUtil.packToPath(packageName);
			File temp = new File(path);
			temp.mkdirs();
			return path;
		}
		return null;
	}
	
	/**
	 * 获取源码路径
	 */
	public static String getSrcPath(String projectType){
		String classPath = FileUtil.class.getClassLoader().getResource("").getPath();
		if(null != projectType && !"".equals(projectType)){
			if("java".equals(projectType)){
				return classPath.replaceAll("(.*/)[^/]+/$", "$1" + "src/");
			}else if("maven".equals(projectType)) {
				return classPath.replaceAll("(.*/)[^/]+/[^/]+/$", "$1" + "src/main/java/");
			}
		}
		return null;
	}
	
	/**
	 * 获取项目路径
	 */
	public static String getProjectPath(String projectType){
		String classPath = FileUtil.class.getClassLoader().getResource("").getPath();
		if(null != projectType && !"".equals(projectType)){
			if("java".equals(projectType)){
				return classPath.replaceAll("(.*/)[^/]+/$", "$1");
			}else if("maven".equals(projectType)) {
				return classPath.replaceAll("(.*/)[^/]+/[^/]+/$", "$1");
			}
		}
		return null;
	}
	
	
	public static String getValue(String key){
		return properties.getProperty(key);
	}
	

	/**
	 * @return the packagename
	 */
	public static String getPackagename() {
		return PACKAGENAME;
	}

	/**
	 * @return the tablename
	 */
	public static String getTablename() {
		return TABLENAME;
	}
	public static String getConpackagename() {
		return CONPACKAGENAME;
	}

	public static String getDomaino() {
		return DOMAINO;
	}
	
}
