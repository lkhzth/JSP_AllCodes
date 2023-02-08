package com.dao;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.common.ConnectionUtill;
import com.domain.BoardVO;

public class BoardDao {

	private DataSource dataSource;
	
	public BoardDao() {
		dataSource = ConnectionUtill.getDatasource();
	}

	// 글목록
	public List<BoardVO> selectAll() {
		String query = "select * from board_tbl order by bno desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				BoardVO vo = BoardVO.builder()
						.bno(rs.getInt("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.imageFileName(rs.getString("imageFileName"))
						.writeDate(rs.getDate("writeDate")).build();
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 글상세
	public BoardVO selectOne(int bno) {
		String query = "select * from board_tbl where bno=?";
		BoardVO vo = null;
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setInt(1, bno);
			try (ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					vo = BoardVO.builder()
							.bno(rs.getInt("bno"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
							.writer(rs.getString("writer"))
							.imageFileName(rs.getString("imageFileName"))
							.writeDate(rs.getDate("writeDate")).build();
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	// 글번호생성
	public int getNewBno() {
		int boardNo = 0;
		String query = "select max(bno)+1 as boardNo from board_tbl";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			if(rs.next()) {
				boardNo = rs.getInt("boardNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardNo;
	}

	// 글 쓰기
	public int insertBoard(BoardVO vo) {
		String query = "insert into board_tbl(bno,title,content, writer, imageFileName) values(?,?,?,?,?)";
		int boardNo = getNewBno();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			pstmt.setString(5, vo.getImageFileName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardNo;
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		String imageFileName = vo.getImageFileName();
		int bno = vo.getBno();
		
		String query = "update board_tbl set title=?, content=?";
		if(imageFileName!=null) {
			query += ", imageFileName=? where bno=?";
		} else {
			query += "where bno=?";
		}
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			if(imageFileName!=null) {
				pstmt.setString(3, vo.getImageFileName());
				pstmt.setInt(4, bno);
			} else {
				pstmt.setInt(3, bno);
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 글 삭제
	public void deleteBoard(int bno) {
		String query = "delete from board_tbl where bno=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
