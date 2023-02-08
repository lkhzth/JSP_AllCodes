package sec01.ex02;

import java.sql.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String contentt;
	private String writer;
	private Date regDate;
	private Date updateDate;
	
	public BoardVO(int bno, String title, String contentt, String writer, Date regDate, Date updateDate) {
		this.bno = bno;
		this.title = title;
		this.contentt = contentt;
		this.writer = writer;
		this.regDate = regDate;
		this.updateDate = updateDate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentt() {
		return contentt;
	}

	public void setContentt(String contentt) {
		this.contentt = contentt;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", contentt=" + contentt + ", writer=" + writer
				+ ", regDate=" + regDate + ", updateDate=" + updateDate + "]";
	}

	
	
}
