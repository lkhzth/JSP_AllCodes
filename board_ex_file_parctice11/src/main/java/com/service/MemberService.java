package com.service;

import com.dao.MemberDAO;
import com.domain.MemberVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberService {
	
	private MemberDAO dao;
	
	// 회원가입
	public void memberJoin(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	// 로그인체크
	public boolean loginService(MemberVO vo) {
		return dao.loginCheck(vo);
	}
}
