package Sample01.ex01;

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

public class MemberDaoImpl implements MemberDao {

	private DataSource dataSource;
	
	public MemberDaoImpl() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) env.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from t_member");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO(
						rs.getInt("mno"),
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("name"),
						rs.getString("email")
			);
			vo.setJoinDate(rs.getDate("joinDate"));
			list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
