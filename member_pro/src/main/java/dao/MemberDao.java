package dao;

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

import domain.MemberVO;

public class MemberDao implements IMemberDao{

	private DataSource dataSource;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDao() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/oracle");
			System.out.println("커넥션풀 생성 : " + dataSource);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberVO> list() {
		List<MemberVO> members = new ArrayList<MemberVO>();
		String query = "select * from t_member";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO(
						rs.getString("u_id"), 
						rs.getString("u_name"), 
						rs.getString("pwd"), 
						rs.getString("email"), 
						rs.getDate("joinDate"));
				members.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}
	
	public void addMember(MemberVO vo) {
		String id = vo.getId();
		String password = vo.getPassword();
		String name = vo.getName();
		String email = vo.getEmail();
		String query = "INSERT INTO T_MEMBER(u_id,pwd,u_name,email) VALUES(?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
