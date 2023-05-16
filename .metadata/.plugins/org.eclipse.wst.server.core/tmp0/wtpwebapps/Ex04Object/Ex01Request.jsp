<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<fieldset>
		<legend>학점확인프로그램</legend>
		<%
		String name = request.getParameter("name");
		int Java = Integer.parseInt(request.getParameter("Java"));
		int Web = Integer.parseInt(request.getParameter("Web"));
		int IoT = Integer.parseInt(request.getParameter("iot"));
		int Android = Integer.parseInt(request.getParameter("and"));
		int sum = Java + Web + IoT + Android;
		int avg = (int) sum / 4;
		String score;
		if (avg >= 95) {
			score = "A+";
		} else if (avg >= 90) {
			score = "A";
		} else if (avg >= 85) {
			score = "B+";
		} else if (avg >= 80) {
			score = "B";
		} else {
			score = "F";
		}
		%>
		<table>
			<tr>
				<td>
					<%
					out.print("이름");
					%>
				</td>
				<td>
					<%
					out.print(name);
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
					out.print("Java점수");
					%>
				</td>
				<td>
					<%
					out.print(Java);
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
					out.print("Web점수");
					%>
				</td>
				<td>
					<%
					out.print(Web);
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
					out.print("IoT점수");
					%>
				</td>
				<td>
					<%
					out.print(IoT);
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
					out.print("Android점수");
					%>
				</td>
				<td>
					<%
					out.print(Android);
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
					out.print("평균");
					%>
				</td>
				<td>
					<%
					out.print(avg);
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
					out.print("학점");
					%>
				</td>
				<td>
					<%
					out.print(score);
					%>
				</td>
			</tr>
		</table>

	</fieldset>

</body>
</html>