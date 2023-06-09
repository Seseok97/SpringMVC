package com.itwillbs.web;

import javax.inject.Inject;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistance.MemberDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	// Test파일은 왜 또만드냐?
	// > Test 동작도 구별될 필요가 있기 때문.
	// 아직 컨트롤러가 없기때문에 Test 파일을 따라 진행해보는 중.(0531)
	
	// 생성한 기능 호출
	// >> DAO 객체가 필요하다!! > 주입받을거임(의존관계)
	@Inject
	private MemberDAO mdao; // 얘를 root-context.xml 가서 찾아온다 !!
	// (root-context.xml에 component-scan으로 미리 등록해둠.)
	
//	@Inject
//	private SqlSession sqlSession; // MemberDAOImpl에 이미 주입되었기때문에 재작성할 필요 없음.
	
	// 로거 > 콘솔창에 메세지 출력
	private static final Logger logger
			=LoggerFactory.getLogger(MemberDAOTest.class);
	
//	@Test
	public void 디비시간정보조회() throws Exception{
		System.out.println("System : "+mdao.getTime());
		logger.info("logger : "+mdao.getTime());

	}// method end

//	@Test
	public void 로그레벨테스트() throws Exception{
//		logger.fatal("fatal"); // 시스템레벨의 로그라서 출력이 안됨.
		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug"); // 보통 디버그 많이 사용함.
		logger.trace("trace");
		
	}// method end
	
//	@Test
	public void 회원가입테스트() throws Exception{
		logger.debug("뷰에서 정보 입력받음!");
		
		MemberVO vo = new MemberVO();
		vo.setUser_id("test5");
		vo.setUser_pw("5555");
		vo.setUser_name("test5");
		vo.setUser_email("5@5.com");
		
		logger.debug("회원가입 완료");
		// DAO객체 주입
		mdao.insertMember(vo);
		
		
	}// method end
//	@Test
	public void 로그인테스트() throws Exception{
		logger.debug("로그인 테스트 시작!");
		
		// 로그인계정
		MemberVO vo = new MemberVO();
		vo.setUser_id("test1");
		vo.setUser_pw("1112");
		
		//DAO > 로그인 체크 메서드 호출
		MemberVO resultVO = mdao.loginMember(vo); // 주입된 메서드 객체를 호출한다.
		if(resultVO == null) {
			logger.debug("login fail");
		}else {
			logger.debug("login success");
		}// i-e end
		
		
		logger.debug("로그인 테스트 끝!");
	}// method end
	
//	@Test
	public void 회원정보수정테스트() throws Exception{
		logger.debug("회원정보수정 테스트 시작![]~(￣▽￣ )~*");
		
		// 수정할 회원정보
		MemberVO uvo = new MemberVO();
		uvo.setUser_id("test1");
		uvo.setUser_pw("1111");
		uvo.setUser_name("test1");
		uvo.setUser_email("1@1.com");
		
		// DAO
		Integer result
			= mdao.updateMember(uvo);
		if(result == 1) {
			logger.debug("정상 수정!");
		}else {
			logger.debug("오류 !");
		}// i-e end
		
		logger.debug("회원정보수정 테스트 끝!*~( ￣▽￣)~[]");
	}// method end
	
	@Test
	public void 회원정보삭제테스트() throws Exception{
		logger.debug("회원정보삭제 테스트 시작![]~(￣▽￣ )~*");
		
		// 삭제할 회원 정보
		MemberVO dvo = new MemberVO();
		dvo.setUser_id("test5");
		dvo.setUser_pw("5555");
		
		//DAO
		Integer result
			= mdao.deleteMember(dvo);
		if(result == 1) {
			logger.debug("정상 삭제!");
		}else {
			logger.debug("오류 !");
		}// i-e end

		logger.debug("회원정보삭제 테스트 끝!*~( ￣▽￣)~[]");
	}// method end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// public class end







