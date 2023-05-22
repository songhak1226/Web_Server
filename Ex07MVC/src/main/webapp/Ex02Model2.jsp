<%@page import="com.smhrd.model.FullStack"%>
<%@page import="java.util.List"%>
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
	List<FullStack> list = (List<FullStack>) session.getAttribute("list");
	%>
	<table border=1>
		<tr>
			<th>이름</th>
			<th>전공</th>
			<th>번호</th>
		</tr>
		<%
		for (FullStack fs : list) {
		%>
		<tr>
			<th><%=fs.getName()%></th>
			<th><%=fs.getMajor()%></th>
			<th><%=fs.getPhone()%></th>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>