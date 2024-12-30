package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass03 {
	public static void main(String[] args) {
		// 수정할 회원의 정보라고 가정하자
		int num = 1; // primary key
		String name = "에이콘";
		String addr = "강남";
		
		// 위의 정보대로 1번 회원의 정보를 수정하는 프로그래밍을 해보세요.
		
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
		
		try {
			// 실행할 미완성의 sql 문
			String sql = """
					UPDATE member
					SET name =?, addr = ?
					WHERE num = ?
				""";
			// 미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt= conn.prepareStatement(sql);
			// 미완성인 sql 문 완성시키기 (?에 순서대로 값 바인딩하기)
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, num);
			
			// sql 문 실행하기
			pstmt.executeUpdate(); // insert, update, delete  는 모두 executeUpdate() 를 호출하면 된다.
			System.out.println("회원정보를 수정했습니다");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
