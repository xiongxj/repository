package com.zxxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxxt.bean.UserPhoneLog;
import com.zxxt.service.IbaseService;
import com.zxxt.serviceImp.UserPhoneLogServiceImp;
import com.zxxt.utils.JsonUtil;



@SuppressWarnings("serial")
public class UserPhoneLogAddServlelt extends HttpServlet  {
	
	private IbaseService baseService=new UserPhoneLogServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserPhoneLog userPhoneLog=new UserPhoneLog();
		userPhoneLog.setId(0);
		userPhoneLog.setOption_date(new Date());
		
		String platform=req.getParameter("platform");
		userPhoneLog.setPlatform(new String((platform==null?"":platform).getBytes("iso-8859-1"),"gbk"));

		String factory=req.getParameter("factory");
		userPhoneLog.setFactory(new String((factory==null?"":factory).getBytes("iso-8859-1"),"gbk"));

		String hardware_version=req.getParameter("hardware_version");
		userPhoneLog.setHardware_version(new String((hardware_version==null?"":hardware_version).getBytes("iso-8859-1"),"gbk"));

		String os_version=req.getParameter("os_version");
		userPhoneLog.setOs_version(new String((os_version==null?"":os_version).getBytes("iso-8859-1"),"gbk"));

		String application_version=req.getParameter("application_version");
		userPhoneLog.setApplication_version(new String((application_version==null?"":application_version).getBytes("iso-8859-1"),"gbk"));
		
		String errorMsg=req.getParameter("errorMsg");
		userPhoneLog.setErrorMsg(new String((errorMsg==null?"":errorMsg).getBytes("iso-8859-1"),"gbk"));
		
		baseService.add(userPhoneLog);
		
		PrintWriter out = resp.getWriter();                   //获得Writer,或者说获得“笔”
        out.println("<html><body><conter>");
       out.println("success!");
       out.println("</html></body></conter>");
        out.close();

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//String jsonString=req.getParameter("");
		String jsonString=" { id : 0, factory : '三星',option_date:'2015-04-12',hardware_version:'ipone',os_version:'4.3' }";
		UserPhoneLog userPhoneLog1=(UserPhoneLog)JsonUtil.getDTO(jsonString, UserPhoneLog.class);
		
	}
}
