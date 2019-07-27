<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<title>参数</title>
        <!-- 加载Query文件-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js">
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
          	  //模拟30000个异步请求，进行并发
              var max = 30000;
              for (var i = 1; i <= max; i++) {
                  //jQuery的post请求，请注意这是异步请求
                  $.post({
                      //请求抢id为1的红包
                      //根据自己请求修改对应的url和大红包编号
                      url: "./userRedPacket/grapRedPacketByRedis.do?redPacketId=1&userId=" + i,
                      //成功后的方法
                      success: function (result) {
                      	console.log("OK")
                      }
                  });
              }
          });
        </script>
  </head>
  
  <body>
  </body>
</html>
