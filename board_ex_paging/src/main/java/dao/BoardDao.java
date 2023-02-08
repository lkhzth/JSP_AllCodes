package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import common.ConnectionUtil;
import domain.BoardVO;
import domain.Criteria;

public class BoardDao {

private DataSource dataSource;
	
	public BoardDao() {
		dataSource = ConnectionUtil.getDataSource();
	}
	
	public List<BoardVO> list(Criteria criteria) {
		List<BoardVO> list = new ArrayList<>();
		String query = "SELECT ROWNUM, BNO, TITLE, CONTENT, WRITER, WRITEDATE";
		query += " FROM (SELECT /*+INDEX_DESC(BOARD_PAGING PK_BOARD)*/ ";
		query += " ROWNUM AS RN, BNO, TITLE, CONTENT, WRITER, WRITEDATE ";
		query += " FROM BOARD_PAGING WHERE ROWNUM <=?) WHERE RN > ?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			int maxRow = criteria.getPageNum()*criteria.getAmount();
			int minRow = (criteria.getPageNum()-1)*criteria.getAmount();
			pstmt.setInt(1, maxRow);
			pstmt.setInt(2, minRow);
			
			try(ResultSet rs = pstmt.executeQuery();){
				while (rs.next()) {
					BoardVO vo = BoardVO.builder()
							.bno(rs.getInt("bno"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
							.writer(rs.getString("writer"))
							.writeDate(rs.getDate("writeDate"))
							.build();
					list.add(vo);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getTotalCount() {
		String query = "select count(bno) as count from board_paging";
		int totalCount = 0;
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			if(rs.next()) {
				totalCount = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}
	
}
