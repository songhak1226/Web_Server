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
	int int_num1 = Integer.parseInt(request.getParameter("num1"));

	int int_num2 = Integer.parseInt(request.getParameter("num2"));

	String ope = request.getParameter("ope");

	int result = 0;

	if (ope.equals("plus")) {
		ope = "+";
		result = int_num1 + int_num2;
	} else if (ope.equals("minus")) {
		ope = "-";
		result = int_num1 - int_num2;
	} else if (ope.equals("mul")) {
		ope = "*";
		result = int_num1 * int_num2;
	} else if (ope.equals("div")) {
		ope = "/";
		result = int_num1 / int_num2;
	}
	;
	out.print(int_num1+ope+int_num2+"="+result);
	/*
	if (ope.equals("plus")) {
		out.print(int_num1 + "+" + int_num2 + "=" + (int_num1 + int_num2));
	} else if (ope.equals("minus")) {
		out.print(int_num1 + "-" + int_num2 + "=" + (int_num1 - int_num2));
	} else if (ope.equals("mul")) {
		out.print(int_num1 + "*" + int_num2 + "=" + (int_num1 * int_num2));
	} else if (ope.equals("div")) {
		out.print(int_num1 + "/" + int_num2 + "=" + (int_num1 / int_num2));
	}
	;
	*/
	%>
</body>
</html>