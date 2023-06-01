package com.itwillbs.persistance;

import com.itwillbs.domain.MemberVO;

// persistance 영속성 > DB관련 처리

public interface MemberDAO {
	// 필요한 동작들을 추상메서드를 사용하여 정의! (만들어두기만 한다.)

	//DB 시간정보 조회
	public String getTime();
	
	// C - 회원정보, 가입
	public void insertMember(MemberVO vo); 
	
	// R - 로그인
//	public int login(String id, String pw); // 기존방식
	public MemberVO loginMember(MemberVO vo);
	public MemberVO loginMember(String id, String pw); // 메서드 오버로딩 (기존 방식, VO객체를 가능하면 항상 사용해야 한다.)
	
	// U - 회원정보 수정
	public Integer updateMember(MemberVO uvo); // 참조를 위해서 Integer으로 입력
	
	// D - 회원정보 삭제
	public Integer deleteMember(MemberVO dvo); // 참조를 위해서 Integer으로 입력
	
}// public interface end
