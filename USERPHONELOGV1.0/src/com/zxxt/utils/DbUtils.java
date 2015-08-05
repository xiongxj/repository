package com.zxxt.utils;
/**
 * 数据库连接信息
 * @author Administrator
 *
 */
public class DbUtils {
	
	private static String IP="jdbc:mysql://localhost:";
	 
	private static String PORT="3306";
	
	private static String DBNAME="/user_phone_log";
	
	public static String NAME="root";
	
	public static String PWD="zxxk";
	
	/**
	 * 配置数据库的连接地址
	 * @return
	 */
	public static String getDbUrl(){
		return IP+PORT+DBNAME;
	}
}
