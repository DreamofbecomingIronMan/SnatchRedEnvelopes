<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <h1>Hello SpringMVC</h1> <br>
    <input type="text" id="name"/>
    <input type="button" id="btn" value="提交"/>
  </body>
  
  <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
  <script type="text/javascript">
      $('#btn').click(function(){
                  $.ajax({
                  	url:"SpringMvc/getPerson",
                  	type:"POST",
                  	dataType: "json",
                  	data:{name:$('#name').val()}
                  });
              })       
  </script>
</html>
