package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistance.MemberDAO;

//@Service : 스프링(root-context.xml)에서, 해당 객체를 서비스객체로 인식하게 설정한 것!!
@Service
public class MemberServiceImpl implements MemberService {
	
	// DAO-Controller 연결
	
	// DAO 객체 접근 필요 > 의존관계!
	@Inject
	private MemberDAO mdao; // 의존성 주입
	
	// 회원가입
	@Override
	public void memberJoin(MemberVO vo) {
		mdao.insertMember(vo); // 회원가입 동작	
	}// memberJoin() method end
	
	// 로그인
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		MemberVO resultVO = mdao.loginMember(vo);
		return resultVO;
	}// memberLogin() method end
	
	// 회원정보 조회
	@Override
	public MemberVO getMember(String id) {
		return mdao.getMember(id); // 메서드와 연결만 해주고 빠진다.
	}// getMember() method end

	// 회원정보 수정
	@Override
	public Integer memberModify(MemberVO uvo) {
		Integer result = mdao.updateMember(uvo);
		return result;
	}// memberModify() method end

	// 회원정보 삭제
	@Override
	public Integer deleteMember(MemberVO dvo) {
		Integer result = mdao.deleteMember(dvo);
		return result;
	}// deleteMember() method end
	
	// 회원정보 목록
	@Override
	public List<MemberVO> getMemberList() {
		 List<MemberVO> memberList =  mdao.getMemberList();
		return memberList;
	}// getMemberList() method end
	
	

} // public class end
