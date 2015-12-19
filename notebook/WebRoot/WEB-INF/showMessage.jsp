<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'showMessage.jsp' starting page</title>
  </head>
  
  <body>
    <font size="5"><b><a href="${pageContext.request.contextPath}/goPublishMessageUI.do?flag=goPublishMessageUi">发布信息</a></b></font>&nbsp;&nbsp;
    <font size="5"><b><a href="/NoteBook/login.do?flag=logout">退出系统</a></b></font><br/>
    <b>欢迎您，${userInfo.userName} &nbsp;留言信息：</b>
    
    <table border="1">
    <tr><td>发送人</td><td>发送时间</td><td>接收人</td><td>信息内容</td></tr>
    <c:forEach items="${messageList}" var="message">
    <tr>
    <td>${message.sender.userName}</td>
    <td>${message.mesTime}</td>
    <td>${message.getter.userName}</td>
    <td>${message.content}</td>
    </tr>
    </c:forEach>
    </table>
   
    
  </body>
</html>