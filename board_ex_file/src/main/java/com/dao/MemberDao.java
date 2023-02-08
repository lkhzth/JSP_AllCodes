package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.common.ConnectionUtil;
import com.domain.BoardVO;
import com.domain.MemberVO;

public class MemberDao {

private DataSource dataSource;
	
	public MemberDao() {
		dataSource = ConnectionUtil.getDatasource();
	}
	
	// 회원가입
	public void insertMember(MemberVO vo) {
		String query = "INSERT INTO t_member(mno,id,pwd,name,email) VALUES (mno_seq.nextval,?,?,?,?)";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query); 
		){
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 로그인체크
	public boolean loginCheck(MemberVO vo) {
		boolean result = false;
		String query = "select decode(count(*),1,'true','false') as RESULT from t_member where id=? and pwd=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query); 
		){
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			try (ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					result = Boolean.parseBoolean(rs.getString("RESULT"));
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
