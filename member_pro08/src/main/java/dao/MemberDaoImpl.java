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
		List<MemberVO> vo = new ArrayList<>();
		String query = "select * from t_member";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				MemberVO list = new MemberVO();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void addMember(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delMember(int mno) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isExisted(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
