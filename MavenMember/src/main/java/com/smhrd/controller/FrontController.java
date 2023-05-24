package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ~.do 요청을 모두 받아줄 컨트롤러(프론트 컨트롤러)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Command> list = null;

	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<>();
		list.put("/join.do", new JoinController());
		list.put("/login.do", new LoginController());

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqUri = request.getRequestURI(); // 요청 경로
		String contextPath = request.getContextPath(); // contextpath : 서버에서 프로젝트를 구별하기 위해 쓰는 경로
		String key = reqUri.substring(contextPath.length()); // /join.do, /login.do

		Command controller = list.get(key);
		String des = controller.process(request, response);
		System.out.println(des);

		if (des.equals("joinSuccess.jsp")) {
			// forwarding
			RequestDispatcher rd = request.getRequestDispatcher(des);
			rd.forward(request, response);
		} else {
			// redirecting
			response.sendRedirect(des);
		}
	}

}
