<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello 컴소!" %></h1>
<br/>
<%--
  // JSP 기본객체중 session 객체에 속성을 설정
  session.setAttribute("logined", "comso");
--%>
<a href="hello-servlet">Hello Servlet</a><br/>
<a href="main/index.jsp">SB Admin 2</a><br/>
<a href="pages/login.jsp">Login</a><br/>
<a href="pages/forgot-password.jsp">Reset Password</a><br/>
<!--
  forward(전달) : 요청한 URL이 유지됨
-->

</body>
</html>