package com.kh.realgood.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.kh.realgood.member.model.dto.Member;

public class MemberDAO {

	private Properties prop = null;

	public MemberDAO() throws FileNotFoundException, IOException {
		String fileName = MemberDAO.class.getResource("/com/kh/realgood/sql/member/member.properties").getPath();

		prop = new Properties();

		prop.load(new FileReader(fileName));
	}
	
	/**
	 * 로그인용 DAO
	 * 
	 * @param conn
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Connection conn, Member member) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginMember = null;
		String query = prop.getProperty("loginMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			
			rset = pstmt.executeQuery();

			if (rset.next()) {
				loginMember = new Member(rset.getString("ID"), rset.getString("NAME"),
						rset.getString("JUMIN_FRONT"), rset.getString("JUMIN_REAR"), rset.getString("GENDER").charAt(0),
						rset.getString("GRADE_NAME"), rset.getString("TEL"), rset.getDate("ENROLL_DATE"), rset.getString("NICKNAME"));
			}
		} finally {
			rset.close();
			pstmt.close();
		}

		return loginMember;
	}
	
	/** 회원가입용 DAO
	 * @param conn
	 * @param member
	 * @return
	 */
	public int signUp(Connection conn, Member member) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("signUp");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getMame());
			pstmt.setString(4, member.getJuminFront());
			pstmt.setString(5, member.getJuminRear());
			pstmt.setString(6, member.getGender()+"");
			pstmt.setString(7, member.getTel());
			pstmt.setString(8, member.getNickName());
			pstmt.setString(9, member.getEmailReceive());
			pstmt.setString(10, member.getSmsReceive());

			result = pstmt.executeUpdate();

			
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	private void close(PreparedStatement pstmt) {
		
	}
	
	

	/** 아이디 중복 체크용 DAO
	 * @param conn
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String id) throws Exception {


		PreparedStatement pstmt = null;
		int result = 0;
		
		ResultSet rset = null;
		
		String query = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}finally {
			rset.close();
			pstmt.close();
		}
		
		return result;
	}
}
