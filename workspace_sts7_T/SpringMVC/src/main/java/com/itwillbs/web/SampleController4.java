package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8088/doD
	// http://localhost:8088/doD?data=itwill
	@RequestMapping(value="/doD",method = RequestMethod.GET)
//	public String doD(@ModelAttribute("data") String data) {
//	public String doD(Model model) {
	public String doD(RedirectAttributes rttr) {
		logger.debug("doD() 메서드 호출");
		
//		logger.debug("data" + data);
//		model.addAttribute("data", "ITWILL");
		rttr.addFlashAttribute("data", "ITWILL2"); // 특정 의미를 부여하는 경우에 사용한다. (조회수 무한올리기 막기 ... )
//		return "/doE";
//		return "redirect:/doE"; // 가상주소의 변화O, 화면변화 O (false)
//		return "forward:/doE"; 	// 가상주소의 변화X, 화면변화 O (true)
		return "redirect:/doE"; // redirect를 주로 사용하게 될거임!
	}// doD() method end
	
	// Model 객체
	// RedirectAttributes 객체
	
	// 공통점 : 정보 전달
	// 차이점
	// 	Model 	 > 전달방식 관계 X, URI에 값이 표시된다. 새로고침시 데이터가 유지된다.
	// 	RedirectAttributes > redirect일때만 사용 가능, URI에 값 표시가 되지 않는다. 새로고침시 데이터가 사라진다.
	
	// @ModelAttribute : 내부적으로 Model객체 생성 후, 그 안에 저장하여 사용한다 !!
	
	// http://localhost:8088/doE
	@RequestMapping(value="/doE",method = RequestMethod.GET)
	public String doE(@ModelAttribute("data") String data) {
		logger.debug("doE() 메서드 호출");
		logger.debug("data" + data);
		return "redirect:/doD";
	}// doE() method end

}// public class end
