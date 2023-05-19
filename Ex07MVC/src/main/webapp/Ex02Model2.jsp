<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 세션안에 저장되어있는 학생정보(3명) 테이블 출력 -->
	<%
	String name = (String)session.getAttribute("name");
	String major = (String)session.getAttribute("major");
	String phone = (String)session.getAttribute("phone");
	%>
	이름 : <%=name%><br> 
	전공 : <%=major%><br> 
	번호 : <%=phone%>
</body>
</html>