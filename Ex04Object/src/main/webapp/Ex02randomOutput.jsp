<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String topic = request.getParameter("topic");
	String[] index = request.getParameterValues("item");

	Random rd = new Random();
	String pick = index[rd.nextInt(index.length)];
	%>
	<h1>랜덤 당첨 게임</h1>
	<fieldset align="center">
		<legend>랜덤뽑기</legend>
		<%=topic %><br>
		<%=pick%>
	</fieldset>
</body>
</html>