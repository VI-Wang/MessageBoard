<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'publishMessage.jsp' starting page</title>
  </head>
  
  <body>
    <font size="5"><a href="">查看信息</a></font>&nbsp;&nbsp;<font size="5"><a href="${pageContext.request.contextPath}/login.do?flag=logout">退出系统</a></font>
    <form action="${pageContext.request.contextPath}/goPublishMessageUI.do?flag=publishMessage" method="post">
    <table>
    <tr>
    <td>接收人：</td>
    <td><select name="getter" id="getter">
    <c:forEach items="${userList}" var="getter">
    <option value="${getter.userId}">${getter.userId}:${getter.userName }</option>
    </c:forEach>
    </select></td>
    </tr>
    <tr><td>发送内容</td><td><textarea name="content" rows="5" cols="10">请输入内容</textarea></td></tr>
    <tr><td><input type="submit" value="发布"/></td><td><input type="reset" value="重填"/></td></tr>
    </table>
    </form>
  </body>
</html>