<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.zxxt.bean.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List userPhoneLogList = (List)request.getAttribute("userPhoneLogList");
String startDate=request.getParameter("startDate");
String endDate=request.getParameter("endDate");
String content=request.getParameter("content");
//List userPhoneLogList = new UserPhoneLogServiceImp().selectALL(new HashMap<String, String>(),UserPhoneLog.class.getName());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户操作日志</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/jquery-ui.css" /> 
    <script type="text/javascript"  src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery-ui-datepicker.js"></script> 
	
	<style type="text/css">
	 body{
	  text-align:center;
	  } 
	 table{
	    border-collapse:collapse;
	 }  
	 table th{
	 	background-color: rgb(223,235,247);
	    line-height:24px;
	    color:#056ea4;
	 }
	 table td{
	  	line-height:24px;
	 } 
	 div.bodyDiv{ 
	 	margin:0 0;
	 	border:0px;
	 } 
	 div.selectDiv{ 
	 	margin:0 0;
	 	border:1px solid #7cacd9;
	 	background-color: rgb(226,240,251)
	 }  
	 div#ui-datepicker-div{
	 display:none;
	 }
	 div.leftMenu{
	 width:20%;
	 height:100%;
	 float:left;
	 background-color: rgb(229,242,250);
	 background-repeat: repeat;
	 }
	 div.contentDiv{
	 width:80%;
	 height:100%;
	 clear:right;
	 float:left;
	 }
	 .content{
	 	margin:0 5%;
	 	border:0px;
	 }
	</style>
	
	<script type="text/javascript">
	  $(function(){
		  $("#startDate,#endDate").datepicker({
				showOn: "button",
				buttonImage: "<%=basePath%>/css/images/calendar.gif",
				buttonImageOnly: true
			});
		  
		  $("#startDate").val("<%=startDate==null?"":startDate%>");
		  $("#endDate").val("<%=endDate==null?"":endDate%>");
		  $("#content").val("<%=content==null?"":content%>");
		  
		  
		  $("#contentTable td").mouseenter(function(){
			  var trSeq =$(this).parent().parent().find("tr").index($(this).parent()[0]);
			  $("#contentTable tr").eq(trSeq).css("background-color","rgb(196,232,248)");
			});
		  
		  $("#contentTable td").mouseleave(function(){
			  var trSeq =$(this).parent().parent().find("tr").index($(this).parent()[0]);
			  if(trSeq%2==0)
				  $("#contentTable tr").eq(trSeq).css("background-color","rgb(239,246,254)");
			  else
			  $("#contentTable tr").eq(trSeq).css("background-color","#ffffff");
			});
		  
		  $("#contentTable tr").each(function(i){
			  if(i%2==0){
				  $(this).css("background-color","rgb(239,246,254)");
			  }
		  });
		  
		  var leftMenu=$("#leftMenu");
		  $( "#optionLog" ).change(
		      function( event, data ) {
		    	  leftMenu.text("");
		    	  var sleectedValue=$( "#optionLog option:selected" ).val();
		    	  
		    	  $.ajax({
		    		  type:"GET",
		    		  url: "UserPhoneLogConstantServlelt?sleectedValue="+sleectedValue,
		    		  dataType:"json",
		    		  success: function(result){
		    			  
		    			  $.each(result,function(i){
		    				  if("factory"==sleectedValue)
		    				  leftMenu.append("<li>"+result[i].factory+"</li>");
		    				  
		    		      });
		    		  },
		    		  error:function(xmlHttpRequest,errorThrown,textStatus){
		    			  alert(XMLHttpRequest.status);
		    		  }
		    		});
		      });
	  });
	  
	  

	 
	  
	  
    </script>
  </head>
  
  <body>
    <form id="phoneLog" action="UserPhoneLogServlelt" method="get" >
    
   
    <div class="content">
    <div class="leftMenu" >
    <label >日志：</label>

    <select name="optionLog" id="optionLog">

      <option value="platform">平台</option>

      <option value="factory">厂家</option>

      <option value="hardware_version">型号</option>

      <option value="os_version">硬件版本</option>

      <option value="hardware_version">操作系统版本</option>
      
      <option value="application_version">应用程序</option>

    </select>

    
    <ul id="leftMenu">
    <li>品牌</li>
    <li>品牌</li>
    <li>品牌</li>
    <li>品牌</li>
    <li>品牌</li>
    <li>品牌</li>
    <li>品牌</li>
    </ul>
    </div>
    
    <div class="contentDiv" >
    <div width="90%" height="5%" class="selectDiv">
    <table width="100%" border="0">
    <tr>
     <td width="100%" colsapn="2">日期：&nbsp;&nbsp;<input type="text" id="startDate" name="startDate"> </input> 至：&nbsp;&nbsp;<input type="text" id="endDate" name="endDate" ></input></td>
    </tr>
    <tr>
     <td  width="90%" ><input type="text" size="80" name="content" id="content" value="search"></input></td>
     <td  width="20%" ><input type="submit"  value="查询" ></input></td>
    </tr>
    </table>
    </div>
    <div width="90%" height="90%" class="bodyDiv">
    <table width="100%" border="1" id="contentTable">
    <tr>       
      <th width="5%">编号</th>
      <th width="8%">日期</th>
       <th width="10%">平台</th>
      <th width="10%">厂家</th>
      <th width="10%">型号</th>
      
      <th width="10%">硬件版本</th>
      <th width="10%">操作系统版本</th>
      <th width="10%">应用程序版本</th>
      <th width="27%">错误信息</th>
    </tr>
    <% 
    if(userPhoneLogList!=null){
		   Iterator it = userPhoneLogList.iterator();
		   while(it.hasNext()){
			   UserPhoneLog userPhoneLog = (UserPhoneLog)it.next();
				   %>
				    <tr>
				      <td><%=userPhoneLog.getId() %></td>
				       <td><%=userPhoneLog.getOption_date()==null?"":userPhoneLog.getOption_date() %></td>
				      <td><%=userPhoneLog.getPlatform()==null?"":userPhoneLog.getPlatform() %></td>
				      <td><%=userPhoneLog.getFactory()==null?"":userPhoneLog.getFactory() %></td>
				      <td><%=userPhoneLog.getPhone_type()==null?"":userPhoneLog.getPhone_type() %></td>
				      <td><%=userPhoneLog.getHardware_version()==null?"":userPhoneLog.getHardware_version()%></td>
				      <td><%=userPhoneLog.getOs_version()==null?"":userPhoneLog.getOs_version() %></td>
				      <td><%=userPhoneLog.getApplication_version()==null?"":userPhoneLog.getApplication_version()%></td>
				      <td><%=userPhoneLog.getErrorMsg()==null?"":userPhoneLog.getErrorMsg()%></td>
				    </tr>
		    <%}    
    }%>
  </table>
  </div>
  </div>
  </div>
  </form>
  </body>
</html>
