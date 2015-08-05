package com.zxxt.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxxt.bean.UserPhoneLog;
import com.zxxt.service.IbaseService;
import com.zxxt.serviceImp.UserPhoneLogServiceImp;



@SuppressWarnings("serial")
public class UserPhoneLogServlelt extends HttpServlet  {
	
	private IbaseService baseService=new UserPhoneLogServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String sleectedValue=req.getParameter("sleectedValue");
		System.out.println(sleectedValue);
		Map<String, String> map=new HashMap<String, String>();
		String startDate=req.getParameter("startDate");
		if(startDate!=null && !"".equals(startDate)){
			map.put("startDate", startDate);
		}
		String endDate=req.getParameter("endDate");
		if(endDate!=null && !"".equals(endDate)){
			map.put("endDate", endDate);
		}
		String content=req.getParameter("content");
		if(content!=null && !"search".equals(content)&& !"".equals(content)){
			map.put("content", content);
		}
		List userPhoneLogList = baseService.selectALL(map,UserPhoneLog.class.getName());
		req.setAttribute("userPhoneLogList", userPhoneLogList);
		req.getRequestDispatcher("/userPhoneLog/userPhoneLogList.jsp") .forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*UserPhoneLog userPhoneLog=new UserPhoneLog();
		userPhoneLog.setId(0);
		userPhoneLog.setFactory("苹果");
		userPhoneLog.setOption_date(new Date());
		userPhoneLog.setHardware_version("hv");
		userPhoneLog.setOs_version("ios");
		userPhoneLog.setApplication_version("8.3");
		userPhoneLog.setErrorMsg("错误！");
		baseService.add(userPhoneLog);
		
		String jsonString=" { id : 0, factory : '三星',option_date:'2015-04-12',hardware_version:'ipone',os_version:'4.3' }";
		UserPhoneLog userPhoneLog1=(UserPhoneLog)JsonUtil.getDTO(jsonString, UserPhoneLog.class);
		baseService.add(userPhoneLog1);*/
	}
}
