package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	// board 관련된 DB동작 선언, 호출
	
	// 글쓰기 C
	public void createBoard(BoardVO vo) throws Exception;
	
	// 글 목록 가져오기 R
	public List<BoardVO> readBoardListAll() throws Exception;
	
	// 글 조회수 증가 U
	public void updateViewcnt(Integer bno) throws Exception; // 변경이 자주 일어날 변수의 경우 기본형보다는 참조형이 좋다.
	
	// 글 조회 R
	public BoardVO readBoard(Integer bno) throws Exception;
	
	// 글 수정 U
	public void updateBoard(BoardVO vo) throws Exception;

	// 글 삭제 D
	public void deleteBoard(Integer bno) throws Exception;
}// public interface end
