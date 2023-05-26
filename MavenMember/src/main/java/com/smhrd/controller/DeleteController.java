package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.WebMemberDAO;

public class DeleteController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		//get방식으로 넘어오면 server폴더의 server.xml에서 63번줄에 인코딩방식 지정해줘야하지만 8버전인가부터는 자동으로 해줌
		try {
			String email = request.getParameter("email");
			
			WebMemberDAO dao = new WebMemberDAO();
			int cnt = dao.delete(email);
			
			if(cnt>0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "select.jsp";
	}

}
