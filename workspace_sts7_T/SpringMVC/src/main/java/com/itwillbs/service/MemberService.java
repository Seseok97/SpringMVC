package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	// 구현동작 설계
	public void memberJoin(MemberVO vo);
	
	// 로그인
	public MemberVO memberLogin(MemberVO vo);// id,pw 들어감.
	
	// 회원정보 조회
	public MemberVO getMember(String id);
	
	// 회원정보 수정
	public Integer memberModify(MemberVO uvo); // sql 쿼리가 integer를 반환하기때문.
	
	// 회원정보 삭제
	public Integer deleteMember(MemberVO dvo);
	
	// 회원정보 목록
	public List<MemberVO> getMemberList();

} // interface end
