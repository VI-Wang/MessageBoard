<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
    <h1>用户登录</h1>
    <form action="/NoteBook/login.do?flag=login" method="post">
    <table>
    <tr><td>用户id</td><td><input type="text" style="width: 150px" name="userId"/></td></tr>
    <tr><td>用户密码</td><td><input type="password" style="width: 150px" name="password"/></td></tr>
     <tr><td><input type="submit" value="登录"/></td><td><input type="reset" value="重新填写"/></td></tr>
    </table>
    </form>
  </body>
</html>