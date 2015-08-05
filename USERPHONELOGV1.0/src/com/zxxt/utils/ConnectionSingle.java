package com.zxxt.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 获取数据库的连接
 * @author Administrator
 *
 */
public class ConnectionSingle  {
	
	
	
	public static Connection getInstance() {
		Connection connectionSingle=null;
		try {
		if(connectionSingle==null){
			Class.forName("com.mysql.jdbc.Driver");
			connectionSingle=DriverManager.getConnection(DbUtils.getDbUrl(),DbUtils.NAME,DbUtils.PWD);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return connectionSingle;
	}
}
