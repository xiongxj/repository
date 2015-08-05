package com.zxxt.daoImp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zxxt.dao.IbaseDao;
import com.zxxt.utils.ConnectionSingle;

public class BaseDaoImp implements IbaseDao {

	public int add(Object object) {
		Connection con = ConnectionSingle.getInstance();
		String sql = getSaveObjectSql(object);
        PreparedStatement st = null;
		try {
			st = con.prepareStatement(sql);
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<Object> selectALL(String sql, String className) {
		List<Object> list = new ArrayList<Object>();
		Connection con = ConnectionSingle.getInstance();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Class c = Class.forName(className);
				Object obj = c.newInstance();
				Method[] methods = c.getMethods();
				for (int i = 0; i < methods.length; i++) {
					if (methods[i].getName().startsWith("set")) {
						String methodName = methods[i].getName();
						String columnName = methodName.substring(3,
								methodName.length()).toLowerCase();
						// 得到方法的参数类型
						Class[] parmts = methods[i].getParameterTypes();
						if (parmts[0] == String.class) {
							// 如果参数为String类型，则从结果集中按照列名取得对应的值，并且执行改set方法
							methods[i].invoke(obj, rs.getString(columnName));
						}
						if (parmts[0] == int.class) {
							methods[i].invoke(obj, rs.getInt(columnName));
						}
						if (parmts[0] == Date.class) {
							methods[i].invoke(obj, rs.getDate(columnName));
						}
					}
				}
				list.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 
	 * 解析出保存对象的sql语句
	 * @param object
	 * @return：保存对象的sql语句
	 */
	private String getSaveObjectSql(Object object) {

		// 定义一个sql字符串
		String sql = "insert into ";
		// 得到对象的类
		Class c = object.getClass();
		// 得到对象中所有的方法
		Method[] methods = c.getMethods();
		// 得到对象中所有的属性
		Field[] fields = c.getFields();
		// 得到对象类的名字
		String cName = c.getName();
		// 从类的名字中解析出表名
		String tableName =cName.substring(cName.lastIndexOf(".") + 1,cName.length());
		sql += tableName + "(";
		List<String> mList = new ArrayList<String>();
		List vList = new ArrayList();
		
		for (Method method : methods) {
			String mName = method.getName();
			if (mName.startsWith("get") && !mName.startsWith("getClass")) {
				String fieldName = mName.substring(3, mName.length()).toLowerCase();
				mList.add(fieldName);
				try {
					Object value = method.invoke(object, null);
					if (value instanceof String) {
						vList.add("'" + value + "'");
					} else if (value instanceof Date) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
						vList.add("'" + format.format(value) + "'");
					}else {
						vList.add(value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		for (int i = 0; i < mList.size(); i++) {
			if (i < mList.size() - 1) {
				sql += mList.get(i) + ",";
			} else {
				sql += mList.get(i) + ") values(";
			}
		}

		for (int i = 0; i < vList.size(); i++) {
			if (i < vList.size() - 1) {
				sql += vList.get(i) + ",";
			} else {
				sql += vList.get(i) + ")";
			}
		}
		return sql;
	}
}
