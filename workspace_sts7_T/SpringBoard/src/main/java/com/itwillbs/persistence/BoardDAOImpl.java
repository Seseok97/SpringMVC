package com.itwillbs.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	// DB연결정보, mapper 접근을 대신해주는 객체 > SqlSession 객체
	@Autowired
	private SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";

	// 글쓰기
	@Override
	public void createBoard(BoardVO vo) throws Exception {
		logger.debug("sqlSession객체 > 마이바티스 > Mapper 접근");
		int result = sqlSession.insert(NAMESPACE + ".create", vo);

		if (result != 0) {
			logger.debug("글쓰기 완료!");
		} // if end
	}// createBoard() method end

	// 게시판 조회하기
	@Override
	public List<BoardVO> readBoardListAll() throws Exception {
		logger.debug("readBoardListAll() 메서드 호출");
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}// readBoardListAll() method end

	// 글 조회수 1 증가
	@Override
	public void updateViewcnt(Integer bno) throws Exception {
		logger.debug("upViewcnt() 메서드 호출");
		sqlSession.update(NAMESPACE + ".upViewcnt", bno);
	}// upViewcnt() method end

	// 글 조회
	@Override
	public BoardVO readBoard(Integer bno) throws Exception {
		logger.debug("readBoard() 메서드 호출");
		return sqlSession.selectOne(NAMESPACE + ".readBoard", bno);
	}// readBoard() method end

	// 글 수정
	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		logger.debug("readBoard() 메서드 호출");
		int result = sqlSession.update(NAMESPACE + ".updateBoard", vo);
		if(result == 1) {
			logger.debug(vo.getBno()+"번 글정보 수정 완료!"); // 이런 테스트로그를 잘 찍지 않는데, 이미 jUnit으로 테스트를 마쳤다고 상정하기 때문임!
		}// if end
	}// updateBoard() method end

	// 글 삭제
	@Override
	public void deleteBoard(Integer bno) throws Exception {
		logger.debug("deleteBoard() 메서드 호출");
		sqlSession.delete(NAMESPACE+".deleteBoard",bno);
	}// deleteBoard() method end
	
	
	
	
	
	

	
	
}// public class end
