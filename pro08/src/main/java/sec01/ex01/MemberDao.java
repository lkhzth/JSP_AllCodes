package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "scott";
	private static final String PWD = "tiger";
	private Connection con; // 오라클에 연동하는데 필요한 객체
	private PreparedStatement pstmt; // 데이터베이스에 쿼리문 전달
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		connDB();
		String qeury = "select * from t_member";
		try {
			pstmt = con.prepareStatement(qeury);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// @param : 테이블컬럼(열) 이름
//				String uId = rs.getString("u_id");
//				String uName = rs.getString("u_name");
//				String pwd = rs.getString("pwd");
//				String email = rs.getString("email");
//				Date date = rs.getDate("joinDate");

				MemberVO vo = new MemberVO(
					rs.getString("u_id"),
					rs.getString("u_name"),
					rs.getString("pwd"),
					rs.getString("email"),
					rs.getDate("joinDate")); // MemberVO 객체생성
				list.add(vo); // 리스트에 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		try {
			Class.forName(DRIVER); // OracleDriver객체 생성
			// 커넥션 객체를 얻음
			con = DriverManager.getConnection(URL,USER,PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
