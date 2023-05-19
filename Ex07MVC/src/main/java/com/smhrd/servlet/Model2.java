package com.smhrd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.FullStack;

@WebServlet("/Model2")
public class Model2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Model2로 요청 먼저
		// 1. DB연동
		// 2. SQL 실행 (FullStack 테이블안에 모든 값 가져오기)
		// 3. 3명의 학생 정보 -> 세션
		// -> Ex02Model2.jsp로 이동
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FullStack fs = null;
		// ArrayList : 데이터 검색할때 용이
		// LinkedList : 중간 데이터 삭제, 추가 같은걸 할때 용이
		List<FullStack> list = new ArrayList<FullStack>();
		// ArrayList를 모든 list타입의 상위존재인 List로 업캐스팅
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "service";
			String password = "12345";

			conn = DriverManager.getConnection(url, user, password);

			String sql = "select * from fullstack";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) { //next() -> true(커서가 가리키고 있는 행에 데이터가 있음) / false(없음)
				String name = rs.getString("name"); // 컬럼이름 지정
				String major = rs.getString(2); // 테이블 상 2번째 컬럼값 지정
				String phone = rs.getString("phone");

				// 학생 한명의 정보
				fs = new FullStack(name, major, phone);
				
				// 가지고온 학생 정보를
				
				
				
				HttpSession session = request.getSession();
				
				session.setAttribute("name", name);
				session.setAttribute("major", major);
				session.setAttribute("phone", phone);
			}
			response.sendRedirect("Ex02Model2.jsp");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 클래스 못찾음");
		} catch (SQLException e) {
			System.out.println("sql 예외 발생");
		} catch (Exception e) {
			System.out.println("다른 예외 발생");
			e.printStackTrace(); 
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("finally 예외 발생");
				e.printStackTrace();
			}
		}
	}

}
