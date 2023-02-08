package sec01.ex03;

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
	
	// 회원목록
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		connDB();
		String qeury = "select * from t_member";
		try {
			pstmt = con.prepareStatement(qeury);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// @param : 테이블컬럼(열) 이름

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
	
	// 회원가입
	public void addMember(MemberVO vo) {
		connDB();
		String id = vo.getuId();
		String pwd = vo.getPwd();
		String name = vo.getuName();
		String email = vo.getEmail();
		String query = "INSERT INTO T_MEMBER(u_id,pwd,u_name,email) VALUES(?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원삭제
	public void delMember(String id) {
		String query = "delete from t_member where u_id=?";
		connDB();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션풀
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
