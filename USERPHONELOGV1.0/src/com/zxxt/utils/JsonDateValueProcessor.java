package com.zxxt.utils;

import java.text.SimpleDateFormat; 
import java.util.Date; 

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig; 
import net.sf.json.processors.JsonValueProcessor; 

/**
 * 
 * @author Administrator
 *
 */
public class JsonDateValueProcessor implements JsonValueProcessor { 

	private String format = "yyyy-MM-dd HH:mm:ss"; 

	public JsonDateValueProcessor() { 
		String rowidString="[{\"kl_id\":\"2\",\"kl_title\":\"Test date\",\"kl_content\":\"Test date\",\"kl_type\":\"1\",\"id\":\"1\"},{\"kl_id\":\"2\",\"kl_title\":\"Test\",\"kl_content\":\"Test\",\"kl_type\":\"1\",\"id\":\"2\"}]"; 
		JSONArray array = JSONArray.fromObject(rowidString); 
		for(int i = 0; i < array.size(); i++){     
			JSONObject jsonObject = array.getJSONObject(i);   
	        System.out.println(jsonObject.get("kl_id")); 
		} 
	}

	public JsonDateValueProcessor(String format) { 
	this.format = format; 
	} 

	public Object processArrayValue(Object value, JsonConfig jsonConfig) { 
	return process(value, jsonConfig); 
	} 

	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) { 
	return process(value, jsonConfig); 
	} 

	private Object process( Object value, JsonConfig jsonConfig ) { 
	if (value instanceof Date) { 
	String str = new SimpleDateFormat(format).format((Date) value); 
	return str; 
	} 
	return value == null ? null : value.toString(); 
	} 

	public String getFormat() { 
	return format; 
	} 

	public void setFormat(String format) { 
	this.format = format; 
	} 

} 

