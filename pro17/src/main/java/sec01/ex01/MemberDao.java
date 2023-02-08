package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	
	private DataSource dataSource;
	
	public MemberDao(){
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 회원목록
	public List<MemberVo> listMembers(){
		List<MemberVo> list = new ArrayList<>();
		String query = "select * from t_member order by joinDate desc";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setMno(rs.getInt("mno"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joinDate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 회원가입
	public void addMember(MemberVo vo) {
		String query = "insert into t_member(mno,id,pwd,name,email) values(mno_seq.nextval,?,?,?,?)";
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

	// 회원상세정보 - 단 하나의 회원만 조회
	public MemberVo findMember(String id) {
		MemberVo vo = null;
		String query = "select * from t_member where id=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, id);
			try (ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					vo = new MemberVo(
					rs.getInt("mno"),
					rs.getString("id"),
					rs.getString("pwd"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getDate("joinDate"));
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	// 회원삭제
	public void delMember(int mno) {
		String query = "delete from t_member where mno=?";
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setInt(1, mno);
			pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// 회원수정
	public void modMember(MemberVo vo) {
		String query = "update t_member set pwd=?, name=?, email=? where id=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getPwd());;
			pstmt.setString(2, vo.getName());;
			pstmt.setString(3, vo.getEmail());;
			pstmt.setString(4, vo.getId());;
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


