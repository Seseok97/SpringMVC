package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	// 파라미터 자동수집 예시.
	// doC()
	// http://localhost:8088/web/doC
	// http://localhost:8088/doC?msg=hello 
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC(String msg) {
		logger.debug("doC() 호출!");
		
		logger.debug("msg: "+msg);

		
		return "doC"; // void로 쓴것과 같아짐.
	}// doC() method end
	
	// doC1()
	// http://localhost:8088/doC1
	// http://localhost:8088/doC1?msg=hello 
	@RequestMapping(value = "/doC1", method = RequestMethod.GET)
	public String doC1(@ModelAttribute("msg") String tmp) { 
		// @ModelAttribute("msg") > msg라는 이름으로 뷰페이지에 정보를 전달해준다.
		// 저장한 데이터를 자동으로 뷰페이지에서 사용가능 하도록 하는것!! (el표현식 사용)
		logger.debug("doC1() 호출!");
		
		logger.debug("msg: "+tmp);

		
		return "doC"; // void로 쓴것과 같아짐.
	}// doC() method end
	
	// doC2()
	// http://localhost:8088/doC2
	// http://localhost:8088/doC2?msg=hello&age=20  // 파라미터가 2개 이상인 경우 
	@RequestMapping(value = "/doC2", method = RequestMethod.GET)
	public String doC2(@ModelAttribute("msg") String tmp,
						@ModelAttribute("age") int age) { 
		logger.debug("doC2() 호출!");
		
		logger.debug("msg: "+tmp);
		logger.debug("age: "+age+" age가 int형인지 확인 > "+(age+100));
		
		return "doC"; // void로 쓴것과 같아짐.
	}// doC2() method end
	
	// doC3()
	// http://localhost:8088/doC3
	// http://localhost:8088/doC3?user_id=admin&user_pw=0000&tel=010-0000-0000  // 파라미터가 2개 이상인 경우 
	// 파라미터가 2개 이상인 경우 사용하는 위 코드를 개선한 경우
	@RequestMapping(value = "/doC3", method = RequestMethod.GET)
	public String doC3(MemberVO vo,
						@ModelAttribute("tel") String tel) { 
		logger.debug("doC3() 호출!");
		
		logger.debug("userid: "+vo.getUser_id());
		logger.debug("userpw: "+vo.getUser_pw());
		
		// 주소줄에 없는 데이터
		logger.debug(vo+"");
		logger.debug("tel: "+tel);

		
		return "doC"; // void로 쓴것과 같아짐.
	}// doC3() method end
	
	// DB의 데이터를 뷰페이지에 표현하는 방법
	// doC4()
	// http://localhost:8088/doC4?user_id=admin&user_pw=0000&tel=010-0000-0000
	@RequestMapping(value = "/doC4", method = RequestMethod.GET)
	public String doC4(Model model) { 
		logger.debug("doC4() 호출! > 파라미터가 아닌 정보를 뷰페이지로 전달 !!");
		
		// DB데이터 (임시)
		// 나중에는 DB에서 들고올거 ,,
		MemberVO vo = new MemberVO();
		vo.setUser_id("admin");
		vo.setUser_pw("0000");
		
		//영역에 저장.
//		request.setAttribute(); // 못쓴다!! > Model 객체 사용
		// Model > Spring이 제공하는 컨테이너(박스) .. 그냥 정보 옮겨주는 친구
		model.addAttribute("vo", vo);

		return "doC";
	}// doC4() method end
	
}// public class end































