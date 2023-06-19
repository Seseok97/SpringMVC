package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	// Board에서 수행하는 동작 선언!
	
	// 글쓰기 - Create
	public void insertBoard(BoardVO vo) throws Exception;
	
	// 글 목록 조회 - Read
	public List<BoardVO> getListAll() throws Exception;
	
	// 글 조회수 증가 - update
	public void upViewcnt(Integer bno) throws Exception;
	
	// 글 조회 - read
	public BoardVO getBoard(Integer bno) throws Exception;
	
	// 특정 글 정보 수정 - update
	public void modifyBoard(BoardVO vo) throws Exception;
	
	// 글 삭제
	public void removeBoard(int bno) throws Exception;
	
} // public interface end
