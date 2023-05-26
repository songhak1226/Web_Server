package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class LoginController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url = "";

		try {
			request.setCharacterEncoding("UTF-8");

			String email = request.getParameter("email");
			String pw = request.getParameter("pw");

			WebMember member = new WebMember(email, pw);

			WebMemberDAO dao = new WebMemberDAO();
			WebMember loginMember = dao.login(member);
			
			//loginMember
			if (loginMember != null) { // 로그인 성공
				// 세션 회원정보 저장, index.jsp 이동
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", loginMember);
				url = "index.jsp";
				System.out.println("로그인성공");
			} else { // 로그인 실패
				// 그냥 index.jsp 이동
				url = "index.jsp";
				System.out.println("로그인실패");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 방식 잘못 지정함");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return url;
	}

}
