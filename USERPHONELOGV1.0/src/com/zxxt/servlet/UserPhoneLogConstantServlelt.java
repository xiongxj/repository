package com.zxxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UserPhoneLogConstantServlelt extends HttpServlet  {
	
	private IbaseService baseService=new UserPhoneLogServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");//
		//resp.setCharacterEncoding("GBK"); 
		String sleectedValue=req.getParameter("sleectedValue");
		System.out.println(sleectedValue);
		PrintWriter out = resp.getWriter();
		String tem="["+"{\""+sleectedValue+"\":\"" + "android" +"\"},"+"{\""+sleectedValue+"\":\"" + "phone" +"\"}"+"]";
		//String tem="{\""+sleectedValue+"\":\"" + "android" +"\"}";
		System.out.println(tem);
		out.print(tem);  
		out.close();  
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
