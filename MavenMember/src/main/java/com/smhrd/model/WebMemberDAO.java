package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class WebMemberDAO {

	// SqlSessionFactory 생성 : DB관련 기능을 직접 사용할 수 있는 세션을 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();

	// 회원가입
	public int join(WebMember member) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.insert("WebMemberDAO.join", member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close(); // 자원 반환
		}
		return cnt;
	}

	// 로그인
	public WebMember login(WebMember member) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		WebMember loginMember = null;
		try {
			loginMember = sqlSession.selectOne("WebMemberDAO.login", member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return loginMember;
	}

	// 업데이트
	public int update(WebMember updateMember) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.update("WebMemberDAO.update", updateMember);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	//리스트
	public List<WebMember> select(){
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<WebMember> list = null;
		try {
			list = sqlSession.selectList("WebMemberDAO.select"); // 넘겨줘야 하는 값이 없으면 매개인자는 1개만 쓴다
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	// 삭제
	public int delete(String email) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt = sqlSession.delete("WebMemberDAO.delete",email);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}
}
