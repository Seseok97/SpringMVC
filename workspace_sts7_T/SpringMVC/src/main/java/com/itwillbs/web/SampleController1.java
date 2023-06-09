package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @Controller > 컨트롤러의 역할 수행 (servlet-context에 등록한것.)

// http://localhost:8088/web/ (시작주소)
// http://localhost:8088/web/doA
// http://localhost:8088/web/doA1

@Controller
public class SampleController1 {
	// 로거 생성
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	
	
	// 컨트롤러 메서드의 리턴타입이 'void'인 경우
	// >> /WEB-INF/views/[주소].jsp 를 찾아간다 !!
	// value="/doABC"로 변경하면, doABC.jsp가 없으면 404 출력!
	
	// 컨트롤러에서 필요한 동작을 메서드로 구현
//	@RequestMapping(value = "매핑할 주소", method = 전달방식(get/post/rest ...))
	@RequestMapping(value = "/doA", method = RequestMethod.GET ) // doA주소가 들어오면, get방식으로 doA 동작을 수행한다.
	public void doA() {
		logger.debug("doA() 실행!!");
	}// doA() method end
	
//	@RequestMapping(value = "/doA1")
	@GetMapping(value = "/doA1") // get메서드로 정보전달하는 매핑
	public void doA1() {
		logger.debug("doA1() 실행!!");
	}// doA1() method end
	
	
	

}// public class end
