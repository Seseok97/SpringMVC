package com.itwillbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	// Service 구현 클래스
	
	@Autowired
	private BoardDAO bdao;

	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		// DAO - 글 정보 저장 가능, 호출
		bdao.createBoard(vo);
	}// insertBoard() method end

	// 글정보 조회
	@Override
	public List<BoardVO> getListAll() throws Exception {
		return bdao.readBoardListAll();
	}// getListAll() method end 

	// 글 조회수 1 증가
	@Override
	public void upViewcnt(Integer bno) throws Exception {
		 bdao.updateViewcnt(bno);
	} //upViewcnt() method end

	// 글 정보 조회
	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		return bdao.readBoard(bno);
	}// getBoard() method end

	// 특정 글 수정
	@Override
	public void modifyBoard(BoardVO vo) throws Exception {
		bdao.updateBoard(vo);
	}// modifyBoard() method end

	// 글 삭제
	@Override
	public void removeBoard(int bno) throws Exception {
		bdao.deleteBoard(bno);
	}//removeBoard() method end
	
	
	
	
	
	
	
	
	
	
	
	
} // public class end
