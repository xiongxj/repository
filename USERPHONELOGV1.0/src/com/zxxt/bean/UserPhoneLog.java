package com.zxxt.bean;

import java.util.Date;

/**
 * 
 * @author 用户电话日志信息
 *
 */
public class UserPhoneLog {
	/**
	 * 主键
	 */
	private int id;
	
	/**
	 * 日期
	 */
	private Date option_date;
	
	/**
	 * 平台
	 */
	private String platform;
	
	/**
	 * 厂家
	 */
	private String factory;
	
	/**
	 * 硬件
	 */
	private String hardware_version;
	
	/**
	 * 操作系统版本
	 */
	private String os_version;
	
	/**
	 * 应用版本
	 */
	private String application_version;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	private String phone_type;

	public String getPhone_type() {
		return phone_type;
	}

	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Date getOption_date() {
		return option_date;
	}

	public void setOption_date(Date option_date) {
		this.option_date = option_date;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getHardware_version() {
		return hardware_version;
	}

	public void setHardware_version(String hardware_version) {
		this.hardware_version = hardware_version;
	}

	public String getOs_version() {
		return os_version;
	}

	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}

	public String getApplication_version() {
		return application_version;
	}

	public void setApplication_version(String application_version) {
		this.application_version = application_version;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
