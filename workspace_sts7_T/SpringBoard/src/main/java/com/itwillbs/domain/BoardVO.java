package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Timestamp regdate;
	
//	private String sBoard; 	// lombok을 사용하는 경우, setSBoard();를 사용해야 한다.
							// 또, EL표현식을 사용하는 경우 [객체명].SBoard로 불러와야 한다.
							// 따라서, 항상 소문자로 구성하거나, 혹은 대문자를 2번째 순서에 사용하지 않는것이 좋다.
	
	// bno 	   > Integer
	// viewcnt > int      >> 왜 다름? : 정보전달, 객체전달 > 참조형(null비교가 가능!)
	//								  : int > 계산에 사용되는 경우 많음, null불가!
	
//	// getter / setter
//	public int getBno() {
//		return bno;
//	}
//	public void setBno(int bno) {
//		this.bno = bno;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getWriter() {
//		return writer;
//	}
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//	public int getViewcnt() {
//		return viewcnt;
//	}
//	public void setViewcnt(int viewcnt) {
//		this.viewcnt = viewcnt;
//	}
//	public Timestamp getRegdate() {
//		return regdate;
//	}
//	public void setRegdate(Timestamp regdate) {
//		this.regdate = regdate;
//	}
//	
//	//toString()
//	@Override
//	public String toString() {
//		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", viewcnt="
//				+ viewcnt + ", regdate=" + regdate + "]";
//	}
	
}// public class end
