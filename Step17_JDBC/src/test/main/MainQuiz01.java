package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainQuiz01 {
	public static void main(String[] args) {
		//DB 연결객체를 담을 지역 변수 만들기
				Connection conn=null;
				try {
					//오라클 드라이버 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//접속할 DB 의 정보 @아이피주소: port 번호: db 이름
					String url="jdbc:oracle:thin:@localhost:1521:xe";
					//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
					conn=DriverManager.getConnection(url, "scott", "TIGER");
					//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
					System.out.println("Oracle DB 접속 성공");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					// 실행할 sql 문을 미리 준비하기 (java10 부터 추가된 새로운 문자열 만드는 문법)
					String sql = """
							SELECT deptno, dname, loc
							FROM dept
							""";
					// PreparedStatement 객체의 참조값 얻어오기
					pstmt = conn.prepareStatement(sql);
					// SELECT 문 실행하고 결과 값을 ReaultSet 으로 얻어내기
					rs = pstmt.executeQuery();
					// 반복문 돌면서 
					while(rs.next()) {
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						String loc = rs.getString("loc");
						System.out.println(deptno+" | "+dname+" | "+loc);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
}
