package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberVO;

// @RestController : REST방식으로 처리하는 컨트롤러

@RestController
public class MyRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyRestController.class);
	
	
	// http://localhost:8088/controller/test1
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1() {
		logger.debug("test1() 메서드 호출!!!(≧∇≦)ﾉ");
		// return이 없어 아무일도 일어나지 않음.
	}// test1() method end
	
	// http://localhost:8088/controller/test2
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(String msg) {
		logger.debug("test2() 메서드 호출!!!(≧∇≦)ﾉ");
		// String 리턴시 문자데이터를 전달 (의미)
		// 동작의 결과를 처리!
		return "ITWILL : " + msg;
	}// test2() method end
	
	// http://localhost:8088/controller/test3
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public @ResponseBody MemberVO test3(@RequestBody MemberVO vo) { // @ResponseBody > 안써도 됨! (@RestController가 대신하고 있는 것 !!)
		logger.debug("test3() 메서드 호출!!!(≧∇≦)ﾉ"); // @@RequestBody : JSON 형태의 데이터를 객체 형태로 전환 (형변환)
		// MemberVO를 리턴하는 경우, Json 타입으로 처리한다. (jackson-databind 라이브러리 추가!)
//		MemberVO vo = new MemberVO();
//		vo.setName("길동홍");
//		vo.setTel("010-0000-0000");
		
		// 매개변수로 vo 가져오기.
		// http://localhost:8088/controller/test3?name="길동홍"&tel="010-0000-0000"
		// 위와같은 형태로 값을 전달해야 null값이 없어질것임!!
		return vo;
	}// test3() method end
	
	// http://localhost:8088/controller/test4
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public List<MemberVO> test4() {
		logger.debug("test4() 메서드 호출!!!(≧∇≦)ﾉ");
		// List형태의 데이터를 리턴하는 경우, JSON Array 형태로 데이터 생성!!
		List<MemberVO> memberList 
				= new ArrayList<MemberVO>();
		for(int i=0;i<10;i++) {
			MemberVO vo = new MemberVO();
			vo.setName("홍길동 "+i+"호");
			vo.setTel("010-0000-000"+i);
			memberList.add(vo);
		}// for end
		return memberList;
	}// test4() method end
	
	// http://localhost:8088/controller/test5
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public Map<Integer, MemberVO> test5() { // 제네릭은 참조형만 사용할 수 있다!! (int를 써다놓고 틀린그림찾기 시키기도 한다.)
		logger.debug("test5() 메서드 호출!!!(≧∇≦)ﾉ");
		// Map 형태의 데이터를 리턴하는 경우, JSON Object의 형태로 데이터를 생성한다 !
		Map<Integer, MemberVO> memberMap
				= new HashMap<Integer, MemberVO>();
		for(int i=0;i<10;i++) {
			MemberVO vo = new MemberVO();
			vo.setName("홍길동 "+i+"호");
			vo.setTel("010-0000-000"+i);
			memberMap.put(i,vo);
		}// for end
		return memberMap;
	}// test5() method end
	
	// http://localhost:8088/controller/test6
	// http://localhost:8088/controller/600
	// http://localhost:8088/controller/numbers/605
	@RequestMapping(value = "/numbers/{num}", method = RequestMethod.GET)
	public String test6(@PathVariable("num") int num) {
		logger.debug("test6() 메서드 호출!!!(≧∇≦)ﾉ");
		logger.debug("/numbers/{num} 호출!!!(≧∇≦)ﾉ");
	
		return "num : " + num;
	}// test6() method end
	
	// ResponseEntity 객체 : REST 방식의 처리는 뷰페이지가 없다 !!!
	// > 페이지의 상태가 알기 어렵다 !! ==> 결과데이터 + HTTP 상태코드를 통하여 알아내야 함.

}// public class end































