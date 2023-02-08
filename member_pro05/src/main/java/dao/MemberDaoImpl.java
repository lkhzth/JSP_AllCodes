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

import model.MemberVO;

public class MemberDaoImpl implements MemberDao {

	private static MemberDaoImpl dao = new MemberDaoImpl();
	
	private DataSource dataSource;
	
	public MemberDaoImpl() {
		try {
			Context context = new InitialContext();
			Context env = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) env.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDaoImpl getInstance() {
		return dao;
	}
	
	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		String query = "select * from t_member";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
				while (rs.next()) {
					MemberVO vo = new MemberVO();
					vo.setMno(rs.getInt("mno"));
					vo.setId(rs.getString("id"));
					vo.setPwd(rs.getString("pwd"));
					vo.setName(rs.getString("name"));
					vo.setEmail(rs.getString("email"));
					vo.setJoinDate(rs.getDate("joinDate"));
					list.add(vo);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addMember(MemberVO vo) {
		String query = "insert into t_member(mno,id,pwd,name,email) values(MNO_SEQ.NEXTVAL,?,?,?,?)";
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

	@Override
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

	@Override
	public boolean isExisted(MemberVO vo) {
		boolean result = false;
		String query = "select decode(count(*),1,'true','false') as result "
						+ "from t_member where id=? and pwd=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			try (ResultSet rs = pstmt.executeQuery();){
				while (rs.next()) {
					result = Boolean.parseBoolean(rs.getString("result"));
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
