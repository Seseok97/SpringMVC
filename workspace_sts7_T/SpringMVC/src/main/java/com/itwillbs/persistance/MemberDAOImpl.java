package com.itwillbs.persistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

//@Repository : 스프링에 해당 파일이 DAO의 동작을 하는 객체라고 등록하는 것.

@Repository
public class MemberDAOImpl implements MemberDAO {
	// 1,2 DB 연결
	// 3, SQL작성, pstmt
	// 4. SQL 실행
	// 5. 데이터 처리 ... 기존에 DAO에서 하던 일!!
	
	// 1,2 DB 연결			> SqlSessionFactory 객체 주입
	@Inject
//	private SqlSessionFactory sqlFactory; // bean으로 인식된다.
	private SqlSession sqlSession; // sqlFactory는 select() 사용이 불가능하여 변경, 이후 다른 객체를 주입받아 사용할거임!
	// 3, SQL작성, pstmt	> memberMapper.xml에 작성하였음
	
	private static final String NAMESPACE="com.itwillbs.mapper.MemberMapper";
	// 상수는 final인데 왜 static 주나 ? > 관례적인것 ,,
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	@Override
	public String getTime() {
		String time = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime"); // select()는 리턴값이 없기때문에 selectOne() 사용
		
		System.out.println("DB시간 정보 : "+time);
		
		return time;
	}// getTime() method end
	// 4. SQL 실행			>
	// 5. 데이터 처리 		>
	
	
	// C - 회원가입
	@Override
	public void insertMember(MemberVO vo) {
		// 1,2 DB 연결
		// 3, SQL작성, pstmt
		// 4. SQL 실행
//		sqlSession.insert("com.itwillbs.mapper.MemberMapper"+".insertMember", parameter);
		sqlSession.insert(NAMESPACE+".insertMember", vo); // ". 주의 !!"
		logger.debug("회원가입 완료!");

	}//insertMember() method end
	
	
	
	// R - 로그인
	@Override
	public MemberVO loginMember(MemberVO vo) {
		logger.debug("테스트 > DAO 호출 : 로그인 동작 수행");
		// sql구문 작성
		logger.debug("DAO > mapper 사용 > sql 실행");
		MemberVO resultVO 
			= sqlSession.selectOne(NAMESPACE + ".login", vo); // id, pw (sql구문 실행)
		// 데이터 전달
		logger.debug("SQL 실행결과를 리턴! > 테스트로 전달");
		logger.debug(resultVO+"");
		return resultVO; // 결과가 없는경우 null을 리턴하는 메서드임.
	}//loginMember() method end
	
	// 오버로딩된 메서드를 오버라이딩.
	@Override
	public MemberVO loginMember(String id, String pw) {
		// 아이디, 비밀번호를 전달받아서 사용. 
		// >> 1개 이상의 정보를 mapper에 각각 전달이 불가능 .. > VO객체에 저장하면 사용가능!
//		MemberVO vo = new MemberVO();
//		vo.setUser_id(user_id);
//		vo.setUser_pw(user_pw);
		
		// 만약 전달된 정보가 하나의 객체에 저장이 불가능한 경우는? > Map을 사용한다.
		Map<String, Object> params = new HashMap<String, Object>();
		
		// params.put("mapper에 매핑된 이름", 전달되는 값)
		params.put("user_id", id);
		params.put("user_pw", pw);
		
		// SQL 호출, 실행
//		sqlSession.selectOne(NAMESPACE+".login",vo); 
		sqlSession.selectOne(NAMESPACE+".login",params); // > 단일 객체에 담기 어려운 경우, Map을 활용하기! 
		// > 가능은 하지만, 일을 두번하는 느낌 .. 그냥 DAO에서 미리 조정하여 객체단위로 가져오는것이 낫다!
		return null;
	}//loginMember() method end
	
	
	// U - 회원정보 수정
	@Override
	public Integer updateMember(MemberVO uvo) {
		logger.debug("테스트 > DAO 호출 : 회원정보 수정!");
		// 수정할 정보를 가져옴 (uvo)
		logger.debug("DAO > mapper 호출 > SQL 실행!");
		Integer result
			= sqlSession.update(NAMESPACE+".update", uvo); // 업데이트된 rows(행)의 수를 리턴한다.
		
		logger.debug("SQL 실행결과를 리턴!");
		
		return result;
	}// updateMember() method end

	// D - 회원정보 삭제
	@Override
	public Integer deleteMember(MemberVO dvo) {
		logger.debug("테스트 > DAO 호출 : 회원정보 삭제!");
		// 수정할 정보를 가져옴 (dvo)
		logger.debug("DAO > mapper 호출 > SQL 실행!");
		Integer result
			= sqlSession.delete(NAMESPACE+".delete",dvo);
		logger.debug("SQL 실행결과를 리턴!");
		
		return result;
	}//deleteMember() method end

	// 회원정보 조회
	@Override
	public MemberVO getMember(String id) {
		logger.debug("getMember() method 실행"); 
		
//		MemberVO ivo = 
//				sqlSession.selectOne(NAMESPACE+".getMember",id);
		
		return sqlSession.selectOne(NAMESPACE+".getMember",id);
//		return ivo;
	}// getMember() method end

	// 회원정보 목록
	@Override
	public List<MemberVO> getMemberList() {
		logger.debug("getMemberList() method 실행"); 
		
		return sqlSession.selectList(NAMESPACE+".memberList");
	} //getMemberList() method end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// public class end
