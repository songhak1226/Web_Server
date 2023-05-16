package com.smhrd.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;


@WebServlet("/Ex04")
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String checkpw = request.getParameter("checkpw");
		String gender = request.getParameter("gender");
		String bloodtype = request.getParameter("bloodtype");
		String birth = request.getParameter("birth");
		String[] hb = request.getParameterValues("hb");
		String color = request.getParameter("color");
		String text = request.getParameter("text");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("아이디 : "+id+"<br>");
		out.println("비밀번호 : "+pw+"<br>");
		if(pw.equals(checkpw)) {
			out.println("비밀번호가 일치합니다."+"<br>");
		} else {
			out.println("비밀번호가 일치하지 않습니다."+"<br>");
		}
		out.println("성별 : "+gender+"<br>");
		out.println("혈액형 : "+bloodtype+"<br>");
		out.println("생일 : "+birth+"<br>");
		out.println("취미 : "+Arrays.toString(hb)+"<br>");
		out.println("좋아하는 색 : "+color+"<br>");
		out.println("남기고 싶은 말 : "+text+"<br>");
	}

}
