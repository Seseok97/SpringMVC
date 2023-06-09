package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

// 컨트롤러 구현 전 정하면 좋은 것들.
// - 컨트롤러별 공통 주소 (URI) 설계
// - 각 기능별 주소(URI) 설계
// - 각 URI별 호출방식 설정(GET/POST) 
//		> 사용자의 정보입력,조회(GET)
//		> 데이터 처리, Db접근(POST)  >> 해당 분류가 일반적인 방식.
// - 결과처리, 페이지 이동 설계
// - 예외처리


@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스의 정보가 필요함. > 의존관계
	@Inject
	private MemberService mService;
	
	// 동작 구현 > 메서드 설계
	
	// http://localhost:8088/member/MemberJoin.me
	// http://localhost:8088/member/join
	// 회원가입 처리 - 정보 입력
//	@RequestMapping(value="/MemberJoin.me",method=RequestMethod.GET)
	@RequestMapping(value="/join",method=RequestMethod.GET)
//	public String memberJoin() {
	public String memberJoinGET() {
		logger.debug("memberJoinGET() 호출![]~(￣▽￣)~*");
		logger.debug("/member/MemberJoin.jsp로 뷰페이지 연결!"); // 자동으로 연결, 리턴타입이 void 이기때문.
		
		return "/member/MemberJoin";
	}// memberJoinGET() method end
	// 회원가입 처리 - 정보 처리
//	@RequestMapping(value="/MemberJoinAction.me",method=RequestMethod.POST)
	@RequestMapping(value="/join",method=RequestMethod.POST)
//	public void memberJoinAction() {
	public String memberJoinPOST(HttpServletRequest request, MemberVO vo) throws Exception {	
		logger.debug("memberJoinPOST() 호출![]~(￣▽￣)~*");
		
		// 한글처리! (POST방식 사용하기때문.) > !!주의 !! 현재 상태로는 request 객체 사용이 불가하다.
//		request.setCharacterEncoding("UTF-8"); // > 사용이 안됨. 필터로 대체해야 한다.
		// 전달정보 저장 (회원가입정보 - 파라미터)
//		MemberVO vo = new MemberVO();
//		vo.setUser_id(request.getParameter("user_id"));
		
		logger.debug(vo+" ");
		
		// 서비스 > 회원가입메서드 호출
		// >> DAO > 회원가입 메서드 호출
		mService.memberJoin(vo);
		// 페이지 이동
		
		return "redirect:/member/login"; // 주소를 변경하면서 페이지 이동
		
	}// memberJoinPOST() method end
	// >> GET / POST 의 전달방식을 사용하여 하나의 메서드로 두가지 동작을 수행할 수 있다.
	
	// http://localhost:8088/member/login
	// 로그인 > 정보입력 (GET)
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() {
		logger.debug("loginGET() 호출![]~(￣▽￣)~*"); 
		logger.debug("연결된 뷰페이지로 이동! (/member/login.jsp)"); 
	}// loginGET() method end
	
	// 로그인 > 정보처리(POST)
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(MemberVO vo,HttpSession session) { //@ModelAttribute ,,, vo로 대체 가능
		// 의존성 주입(DI) > 약한결합을 위해 메서드 내부에서 객체를 생성하지 않고 파라미터로 받아온다!!!
		logger.debug("loginPOST() 호출![]~(￣▽￣)~*");
		// 전달정보(id,pw 저장)
		logger.debug(vo+""); // 프레임워크에서 대신해주는 일이 많다보니 데이터 놓치는 경우 많음.
							 // 항상 데이터가 잘 넘어오는지 확인하는 과정이 중요함!
		// DB에서 정보 체크(Service에서 실행)
		MemberVO resultVO = mService.memberLogin(vo);
		logger.debug(resultVO+"");
		// 로그인 여부에 따라서 페이지 이동
		
		// 로그인 성공 > 메인(redirect) + session에 id저장
		// 로그인 실패 > 로그인페이지로 다시 이동
		if(resultVO != null) {
			// 로그인 성공
			logger.debug("로그인 성공![]~(￣▽￣)~*");
			// 메인페이지로 이동, 세션에 id 저장
			session.setAttribute("id", resultVO.getUser_id());
			
			return "redirect:/member/main";
		}else {
			// 로그인 실패
			logger.debug("로그인 실패![]~(￣▽￣)~*");
			// 로그인페이지로 이동
			return "redirect:/member/login";
		}// i-e end
	}// loginPOST() method end
	
	// http://localhost:8088/member/main
	// 메인페이지
	@RequestMapping(value = "/main", method = RequestMethod.GET )
	public void mainGET() {
		logger.debug("mainGET() 호출![]~(￣▽￣)~*");
		
		
		logger.debug("member/main.jsp로 이동![]~(￣▽￣)~*");
	}//mainGET() method end
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(MemberVO vo, HttpSession session) {
		logger.debug("logoutGET() 호출![]~(￣▽￣)~*");
		
		// 세션정보 초기화
		session.invalidate();
		
//		return "redirect:/member/login";
		return "redirect:/member/main"; // 같은동작을 수행한다.
	}//logoutGET() method end
	
	// 회원정보 조회
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void infoGET(MemberVO vo,HttpSession session, Model model) { // @ModelAttribute 쓰려고했는데 아님!
		logger.debug("infoGET() 호출![]~(￣▽￣)~*");
		
		// 회원정보 가져오기 > 세션의 아이디정보를 이용, DB의 회원정보 모두 조회
		// 서비스 > DAO
		String id = (String)session.getAttribute("id");
		MemberVO resultVO = mService.getMember(id);
		// 연결된 뷰페이지에 전달
		logger.debug("resultVO : "+resultVO);
		
//		model.addAttribute("resultVO", resultVO);
		model.addAttribute(resultVO); // 전달되는 VO의 클래스명의 앞글자를 소문자로 변경하여 전달하게 됨.
		
		// 페이지 이동 > void 주면 value에 넣은 페이지로 그대로 넘어감
//		return "redirect:/member/info"; >> 이거 넣으면 무한루프 걸림.
		
	}//infoGET() method end
	
	// 회원정보 수정 > 기존의 정보출력 + 수정정보 입력
	// 회원정보 수정 > 정보 수정 (처리)
	@RequestMapping(value = "/modify", method = RequestMethod.GET) // method 미정의시 get/post 둘다 가능
	public void modifyGET(@SessionAttribute String id,Model model) { // session에서 id를 가져옴.
		logger.debug("modifyGET() 호출![]~(￣▽￣)~*");
		
		logger.debug("id > "+id);
		// 기존의 회원정보를 화면에 보여주기.
		MemberVO resultVO = mService.getMember(id);
		// 정보 저장 (Model객체 사용)
		model.addAttribute(resultVO); // memberVO로 전달된다.
		// 이름, 이메일 수정 가능 > id,pw 동일
		// /member/modify.jsp 페이지 이동 (출력)
	}// modifyGET() method end
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(MemberVO uvo) {
		logger.debug("modifyPOST() 호출![]~(￣▽￣)~*");
		// 한글처리 > 필터로 처리 >> 돼있음
		// 전달정보 저장 (수정 데이터)
		logger.debug("파라미터 자동수집");
		logger.debug("uvo"+uvo);
		// 서비스 > 회원정보 수정기능 구현 
		int result = mService.memberModify(uvo);
		
		logger.debug("result > "+result);
		
		// 결과에 따라 페이지 이동
		if(result == 1) {
			logger.debug("수정 성공");
			return "redirect:/member/main";
		}else {
			logger.debug("수정 실패");
			return "redirect:/member/modify";
		} // i-e

	}// modifyPOST() method end
	
	// 회원정보 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void deleteGET() {
		logger.debug("deleteGET() 호출![]~(￣▽￣)~*");
		// 아무동작 안함
		logger.debug("member/delete.jsp로 이동![]~(￣▽￣)~*");
	}// deleteGET() method end
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(@SessionAttribute String id,
							@ModelAttribute("user_pw") String user_pw, 
							HttpSession session) {
		logger.debug("deletePOST() 호출![]~(￣▽￣)~*");
		// pw받기
		logger.debug("id > "+id);
		logger.debug("pw > "+user_pw);
		
		MemberVO vo = new MemberVO();
		vo.setUser_id(id);
		vo.setUser_pw(user_pw);
		
		int result = mService.deleteMember(vo);
		
		if(result == 1) {
			logger.debug("삭제 성공");
			session.invalidate();
			return "redirect:/member/main";
		}else {
			logger.debug("삭제 실패");
			return "redirect:/member/delete";
		}// i-e end
	}//deletePOST() method end
	
	// 회원정보 목록 출력
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(Model model) {
		logger.debug("listGET() 호출![]~(￣▽￣)~*");
		
		// 서비스 > 회원목록 가져오기
		List<MemberVO> memberList = mService.getMemberList();
		// Model 객체에 저장
		model.addAttribute("memberList",memberList);
		// 뷰페이지에서 출력
		
		
	}//listGET() method end
	

}// public class end


































