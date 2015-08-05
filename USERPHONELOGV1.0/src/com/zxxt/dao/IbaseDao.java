package com.zxxt.dao;

import java.util.List;
/**
 * 数据库操作
 * @author Administrator
 *
 */
public interface IbaseDao {
	
	/**
	 * 新增
	 * @param sql
	 * @return
	 */
	public int add(Object object) throws Exception;
	
	/**
	 * 查询所有
	 * @return
	 * @throws Exception 
	 */
	public List<Object> selectALL(String sql,String className ) throws Exception;

}
