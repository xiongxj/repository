package com.zxxt.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.zxxt.bean.UserPhoneLog;


public class test {
	public static void main(String[] args) {
		Connection con= ConnectionSingle.getInstance();
		try {
			Object  userPhoneLog = new UserPhoneLog();
			 Class c=Class.forName(userPhoneLog.getClass().getName());
			 java.lang.reflect.Method[] me=c.getMethods();
			//ResultSet rs =con.createStatement().executeQuery("select * from USER_PHONE_LOG");
			System.out.println(me.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
