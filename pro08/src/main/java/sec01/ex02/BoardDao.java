package sec01.ex02;

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

public class BoardDao {
//	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String USER = "scott";
//	private static final String PWD = "tiger";
	
	private DataSource dataSource;
	private Connection con; 
	private PreparedStatement pstmt; 
	
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardVO> listBoards(){ 
		List<BoardVO> list = new ArrayList<BoardVO>();
//		connDB();
		String qeury = "select * from board_tbl";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(qeury);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("contentt"),
						rs.getString("writer"),
						rs.getDate("regDate"),
						rs.getDate("updateDate"));
				list.add(vo);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; 
	}
	
//	private void connDB() {
//		try {
//			Class.forName(DRIVER);
//			con = DriverManager.getConnection(URL,USER,PWD);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
}
