package com.sqxww.generator.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil {
	
	private static Properties info = new Properties();
	private static String url = null;
	
	static{
		Properties properties = new Properties();
		try {
			//加载配置文件
			properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("conf/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			//载入数据库驱动
			Class.forName(properties.getProperty("jdbc.driver"));
			//获取配置文件信息
			info.setProperty("user", properties.getProperty("jdbc.user"));
			info.setProperty("password", properties.getProperty("jdbc.password"));
			url = properties.getProperty("jdbc.url");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, info);
	}
	
	/**
	 * 关闭相关对象
	 * @param con
	 * @param r
	 * @param s
	 * @param ps
	 */
	public static void close(Connection con, ResultSet r, Statement s, PreparedStatement ps){
		try {
			if(null != con && !con.isClosed()){
				con.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if(null != r && !r.isClosed()){
				r.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(null != s && !s.isClosed()){
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(null != ps && !ps.isClosed()){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
