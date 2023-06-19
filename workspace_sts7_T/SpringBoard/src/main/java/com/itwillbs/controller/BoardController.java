package com.itwillbs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*") // 특정 주소에 따른 컨트롤러 구분
public class BoardController {

	// 서비스 객체 주입
	@Autowired
	private BoardService service;

	// logger
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	// 글쓰기 동작 - /board/regist (GET)
	// http://localhost:8088/board/regist
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registGET() throws Exception {
		logger.debug(" registGET() 호출[]~(￣▽￣)~* ");
		logger.debug(" /board/regist.jsp 페이지로 이동!");

	}// registGET() method end
		// 글쓰기 동작 - /board/regist (POST)

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, RedirectAttributes rttr) throws Exception { // BoardVO 타입변수 vo를 생성한 것.
		logger.debug(" registPOST() 호출[]~(￣▽￣)~* ");
//		logger.debug(vo+" ");
		logger.debug("vo : {}", vo); // > err 레벨에서 사용 권장.
//		logger.error(msg); > 조금이라도 자원을 아끼려고 하는 .. 그런거임!

		// 한글처리 : 필터 사용
		// 페이지에 전달된 데이터(파라미터) 저장

		// 서비스 > 글쓰기 동작 호출
		service.insertBoard(vo);
		
		// 리스트로 정보를 전달! (rttr)
		rttr.addFlashAttribute("result", "CREATEOK");
		
		// 리스트페이지로 이동
		return "redirect:/board/listALL";
	}// registPOST() method end

	// http://localhost:8088/board/listALL
	// 게시판 글 목록
	@RequestMapping(value = "/listALL", method = RequestMethod.GET)
	public void listALLGET(Model model,@ModelAttribute("result") String result, HttpSession session) throws Exception {
		logger.debug(" listALLGET() 호출[]~(￣▽￣)~* ");
		logger.debug(" /board/listALL.jsp 페이지로 이동!");
		logger.debug("result : "+result);

		// 서비스 > DB에 저장될 글 정보 가져오기
		List<BoardVO> boardList = service.getListAll();
		
		//조회수 체크값
		session.setAttribute("checkViewCnt", true);
		
		// 연결된 뷰 페이지에 전달.
		logger.debug("boardList : {}", boardList);
		model.addAttribute("boardList", boardList);
		model.addAttribute("result", result);
	}// listALLGET() method end
	
	
	// http://localhost:8088/board/read
	@RequestMapping(value = "/read", method = RequestMethod.GET)
//	public void readGET(@ModelAttribute("bno") int bno, Model model, RedirectAttributes rttr, BoardVO vo) throws Exception {
	public void readGET(@RequestParam("bno") int bno, Model model, HttpSession session) throws Exception {	
		// @RequestParam() , 1:1 매핑, 자동으로 타입캐스팅(형변환)
		// @ModelParameter() + Model, 1:N 매핑
		logger.debug("readGET() 호출[]~(￣▽￣)~* ");
		
		// 전달정보 저장
		logger.debug("bno : {}",bno);
		
		// 조회수 1 증가 > rttr?
//		service.upViewcnt(bno); // 이거 그대로면 새로고침해서 조회수 뻥튀기 할수있음.
								// redirect를 사용하지 않으면, RedirectAttributes도 사용할수 없다.
		// checkViewCnt가 참일때만!
		boolean checkViewCnt = (Boolean)session.getAttribute("checkViewCnt");
		if(checkViewCnt) {
			//동작 호출
			service.upViewcnt(bno);
			session.setAttribute("checkViewCnt", false); // 나갔다가 들어오면 1 올릴수 있다. 이거 막고싶으면 IP따서 비교제어하면됨.
		}// if end
		
		// 글 정보 조회(특정글)
//		service.getBoard(bno);
		// 글 정보 Model 저장 > 뷰페이지로 전달
		model.addAttribute("vo", service.getBoard(bno)); // key 의 이름을 지정할수 있다는 점에서 이쪽을 더 많이 쓴다.
//		model.addAttribute(service.getBoard(bno)); // boardVO > key
		// 뷰페이지로 이동(/board/read.jsp)
	}// readGET() method end
	
	// 수정페이지로 이동
	// http://localhost:8088/board/modify?bno=2
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void updateBoardGET(Model model, @RequestParam("bno") int bno ) throws Exception {
		logger.debug("updateBoardGET() 호출[]~(￣▽￣)~* ");
		// 전달정보 저장(bno)
		logger.debug("bno : {}",bno);
		
		// service > 정보 가져오기
		// Model객체 > 정보전달
		model.addAttribute("vo", service.getBoard(bno));
		// 페이지 이동
	}// updateBoardGET() method end
	// 수정 진행
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String updateBoardPOST(RedirectAttributes rttr, 
			BoardVO vo) throws Exception{ //BoardVO vo > ModelAttribute 어놉테이션이 생략된 형태 
		logger.debug("updateBoardPOST() 호출[]~(￣▽￣)~* ");
		
		// 전달정보 저장
		logger.debug("vo : "+vo);
		// 서비스 > DB에 게시판 글내용 수정 동작
		service.modifyBoard(vo);
		// 상태정보 전달
		rttr.addFlashAttribute("result","MODOK");
		// 페이지로 이동(리스트)
		return "redirect:/board/listALL";
	}// updateBoardPOST() method end
	
	// 삭제페이지로 이동
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeBoardPOST(int bno, RedirectAttributes rttr) throws Exception {
		logger.debug("removeBoardPOST() 호출[]~(￣▽￣)~* ");
		// 전달정보 저장(bno)
		logger.debug("bno : {}",bno);
		// 서비스 > 글정보 삭제동작
		service.removeBoard(bno);
		// 상태정보 전달
		rttr.addFlashAttribute("result", "DELOK");
		// 페이지 이동
		return "redirect:/board/listALL";
	}// removeBoardPOST() method end
	
	
	
}// public class end










































