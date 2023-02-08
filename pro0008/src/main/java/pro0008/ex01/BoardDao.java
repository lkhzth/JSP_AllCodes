package pro0008.ex01;

import java.sql.Connection;
import java.sql.Date;
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
		String query = "select * from board_tbl";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
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

	public void addMember(BoardVO vo) {
		int bno = vo.getBno();
		String title = vo.getTitle();
		String contentt = vo.getContentt();
		String writer = vo.getWriter();
		Date regDate = vo.getRegDate();
		Date updateDate = vo.getUpdateDate();
		
		String query = "INSERT INTO T_MEMBER(bno,title,contentt,writer) VALUES(?,?,?,?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bno);
			pstmt.setString(2, title);
			pstmt.setString(3, contentt);
			pstmt.setString(4, writer);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
