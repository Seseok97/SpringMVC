package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/itwill")
public class SampleController2 {
	// logger 생성
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	// String 타입 리턴 : 
	//  /WEB-INF/views/[리턴된 문자열].jsp 으로 이동!
	// >> 다른 주소로 이동시켜준다! .. 어따쓰는겨??;;
	
	// http://localhost:8088/web/doB
	// http://localhost:8088/web/itwill/doB
	// http://localhost:8088/itwill/doB   // 최종적으로 이런 형태가 되어야 한다 !!
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB() {
		logger.debug(" doB() 호출!!");
		
		logger.debug(" 연결된 뷰페이지로 이동 (컨트롤러 자동 처리)!!");
		return "/itwill/string";
	}// doB() method end
	
	// http://localhost:8088/web/doB1
	// http://localhost:8088/web/itwill/doB1
	@RequestMapping(value = "/doB1", method = RequestMethod.GET)
	public String doB1() {
		logger.debug(" doB1() 호출!!");
		
		logger.debug(" 연결된 뷰페이지로 이동 (컨트롤러 자동 처리)!!");
		return "string"; // 이거때문에 경로 못찾아감
	}// doB1() method end
	
	// 두 메서드는 전달받는 주소는 다르지만, 리턴되는 페이지는 같게 할 수 있다 > 회원등급별 페이지 차이를 발생시킬수 있다!!!
	
	
}// public class end
