package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MyMember;
import com.smhrd.model.MymemberDAO;

public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MyMember member = new MyMember(id,pw);
		
		MymemberDAO dao = new MymemberDAO();
		MyMember member2 = dao.login(member);
		
		// 없는 정보 입력 -> null
		//System.out.println("닉네임 : " + member2.getNick());
		
		if(member2!=null ) { // 로그인 성공
			HttpSession session = request.getSession();
			// 세션에 member2를 저장
			// index.jsp로 이동
			// index.jsp에서는 닉네임 님 환영합니다
			session.setAttribute("member", member2);
			response.sendRedirect("index.jsp");
		} else { // 로그인 실패
			// login.html로 이동
			response.sendRedirect("login.html");
		}
	}

}
