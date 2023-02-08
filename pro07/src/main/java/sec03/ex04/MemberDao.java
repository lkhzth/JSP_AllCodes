package sec03.ex04;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	private static MemberDao dao = new MemberDao();
	private Map<String, String> members = new HashMap<String, String>();
	private MemberDao() {
		members.put("lee", "1234");
		members.put("kim", "2456");
		members.put("park", "3456");
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public boolean login(String id, String pw) {
		String value = members.get(id);
		if(pw.equals(value)) {
			System.out.println("로그인 성공");
			return true;
		}
		return false;
	}
}
