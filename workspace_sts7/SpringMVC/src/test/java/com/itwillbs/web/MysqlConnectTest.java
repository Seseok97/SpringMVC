package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlConnectTest {
	// test 밑에 만든것인지 확인하는것 매우 중요 !!
	// > 일반적으로 클래스는 main() 없이 코드 실행이 불가능하다.
	// > Juint을 사용해서 main()/서버 없이 코드 실행 가능.
	// >> 테스트 개발 가능
	
	// JAVA를 이용한 DB연결 (JDBC, Java DataBase Connecting)
	// 커넥션풀? 전에 JDBC 이용
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb";
	private static final String DBID = "root";
	private static final String DBPW = "1234";
	
	// DB연결 메서드
	// @Test : 테스트할 내용을 메서드 안에 작성, 어노테이션 표시 > Junit이 테스트 동작을 수행해줌.
	@Test 
	public void testDBConnection() {
		System.out.println("testDBConnection(): 디비 연결테스트 시작!");
		
		//1. 드라이버 로드
		try(Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);) { 
			// try-with > finally구문의 자원해제를 대신 구현하는 형태의 예외처리 문법
			// >> 주의 ! 아무거나 넣으면 안됨. 객체가 반드시 AutoClosable  인터페이스를 구현해야한다 !!
			// 클래스의 다중상속은 불가능하지만, 인터페이스는 가능하다(인터페이스끼리는 상속으로 implements를 대신함.).
			Class.forName(DRIVER);
			//2. 디비연결
			
//			Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
			
			System.out.println("DB연결 성공!");
			System.out.println(con);
			
			System.out.println("testDBConnection(): DB연결테스트 종료.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			//자원해제 동작 // 대체할거임.
//		}// tcf end
	}// testDBCon() method end
	

}// public class end
