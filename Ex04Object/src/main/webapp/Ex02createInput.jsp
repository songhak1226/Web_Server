<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>랜덤 당첨 게임</h1>
	<fieldset align="center">
		<legend>랜덤뽑기</legend>
		<form action="Ex02randomOutput.jsp">
			<table>
				<tr>
					<td>주제 :</td>
					<td><input type="text" name="topic"></td>
				</tr>
				<%
				int num = Integer.parseInt(request.getParameter("number"));
				%>
				<%
				for (int k = 1; k <= num; k++) {
				%>
				<tr>
					<td>아이템 : </td>
					<td><input type="text" name="item"></td>
				</tr>
				<%
				}
				%>
			</table>
			<input type="submit" name="랜덤뽑기">
		</form>
	</fieldset>
</body>
</html>