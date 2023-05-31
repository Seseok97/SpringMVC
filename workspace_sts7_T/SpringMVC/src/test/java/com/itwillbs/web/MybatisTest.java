package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistance.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" }
		)
public class MybatisTest {
	
	// 디비연결(+Mybatis) => SqlSessionFactory 객체
	
	// 객체 의존 주입
	@Inject
	private SqlSessionFactory sqlFactory;
	
	// DAO객체 생성 > 객체(MemberDAOImpl) 주입받음
	@Inject
	private MemberDAO mdao; // impl말고 왜 ??
	// == MemberDAO dao = new MemberDAOImpl(); 과 같음 !!
	
	//@Test
	public void test_SqlSessionFactory() throws Exception{
		
		System.out.println("test1");
		System.out.println(sqlFactory);
		
	}
	
//	@Test
	public void test_sqlDBConntect() throws Exception{
 		// 디비연결 + SQL 실행
		SqlSession sqlSession 
		           = sqlFactory.openSession();
		System.out.println("test2");
		System.out.println(sqlSession);	
	}
	
	@Test
	public void 디비시간정보조회() throws Exception{
		// test 메서드는 한글작성이 가능하다. 회사마다 다름.
		// 디비연결 + SQL 실행
//		SqlSession sqlSession 
//        = sqlFactory.openSession();
//		sqlSession.selectOne(""); // 네임스페이스를 불러서 사용하면 되지않나?
		// > 사용안됨 !! DAO가 이미 처리한 동작임.
		String time = mdao.getTime();
		System.out.println("DB시간 정보조회 : "+ time);
		
		
	} // method end
	
	
	
	
	

}
