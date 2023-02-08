package dao;

import java.util.List;

import model.MemberVO;

public interface MemberDao {

	List<MemberVO> memberList();
	
	void addMember(MemberVO vo);
	
	void delMember(int mno);
	
	boolean isExisted(MemberVO vo);
	
	void emailUpdate(String email);

}
