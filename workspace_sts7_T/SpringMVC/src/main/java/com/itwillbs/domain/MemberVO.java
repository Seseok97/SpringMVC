package com.itwillbs.domain;
/**
 * 
 * 도메인 객체
 *	도메인? : 프로젝트에 중요한 개념(명사 형태) ex) 회원, 게시판, 상품 ...
 *	>> DB정보 저장을 위한 DTO
 *
 *	DTO(Data Transfer Object): 데이터를 전달하기위한 객체(DB에서 만들어진 데이터를 일컫는 경우가 많다.)
 * 								[ set/get 포함]
 *	VO(Value Object) : 값을 표현하는 객체
 *								[ get 포함(set X), equals(), hashCode() 포함] >> 쓰는 개념만 존재한다.
 */

import java.sql.Timestamp;

public class MemberVO {
	
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	// getter / setter
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	// getter / setter
	
	// toString()
	@Override
	public String toString() {
		return "MemberVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_email="
				+ user_email + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}

}// public class end
