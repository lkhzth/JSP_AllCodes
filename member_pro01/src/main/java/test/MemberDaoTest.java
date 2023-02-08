package test;

import dao.MemberDao;
import dao.MemberDaoImpl;
import model.MemberVO;

public class MemberDaoTest {
	public static void main(String[] args) {
		MemberDao dao = MemberDaoImpl.getInstance();
		
		System.out.println(dao.memberList());
		
	}
}
