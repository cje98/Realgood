package com.kh.realgood.member.model.service;


import static com.kh.realgood.common.DBCP.getConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import com.kh.realgood.member.model.dao.MemberDAO;
import com.kh.realgood.member.model.dto.Member;

public class MemberService {
	private MemberDAO dao;
	
	public MemberService() throws FileNotFoundException, IOException {
		dao = new MemberDAO();
	}
	
	/** 로그인용 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception {
		
		// 커넥션 얻어오기
		Connection conn = getConnection();
		
		// dao 호출
		Member loginMember = dao.loginMember(conn, member);
		
		// 커넥션 반환
		conn.close();
		
		// 결과 반환
		return loginMember;
	}
	
	/** 회원 가입용 Service
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public int signUp(Member member) throws  Exception{
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member);
		
		if(result >0) {
			conn.commit();
		}else {
			conn.rollback();
		}
		
		conn.close();
		
		return result;
	}
	
	/** 아이디 중복 체크용 Service
	 * @param id
	 * @return
	 */
	public int idDupCheck(String id) throws Exception {
		
		Connection conn = getConnection();
		int result = dao.idDupCheck(conn, id);		
		
		conn.close();
		
		return result;
	}
}
