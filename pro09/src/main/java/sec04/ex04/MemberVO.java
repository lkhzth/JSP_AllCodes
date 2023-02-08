package sec04.ex04;

import java.sql.Date;

public class MemberVO {
	private int mno; // 회원번호
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private String email; // 이메일
	private Date jointDate; // 날짜

	public MemberVO(int mno, String password ,String id, String name, String email) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public MemberVO(String password ,String id, String name, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJointDate() {
		return jointDate;
	}

	public void setJointDate(Date jointDate) {
		this.jointDate = jointDate;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", id=" + id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", jointDate=" + jointDate + "]";
	}

	

	
	
	
}
