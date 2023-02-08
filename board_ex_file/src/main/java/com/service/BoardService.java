package com.service;

import java.util.List;

import com.dao.BoardDao;
import com.domain.BoardVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardService {
	
	private BoardDao dao;

	public List<BoardVO> boardList() {
		return dao.selecAll();
	}
	
	public BoardVO findBoard(int bno) {
		return dao.selectOne(bno);
	}

	public int addBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}
	
	public void modBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}

	public void removeBoard(int bno) {
		dao.deleteBoard(bno);
	}
	
}
