package com.zxxt.service;

import java.util.List;
import java.util.Map;

public interface IbaseService {
	
	/**
	 * 新增
	 * @param sql
	 * @return
	 */
	public int add(Object object);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Object> selectALL(Map<String, String> map,String className);
}
