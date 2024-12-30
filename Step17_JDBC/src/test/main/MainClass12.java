package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.util.DBConnector;

public class MainClass12 {
	public static void main(String[] args) {
		int num = 1;
		
		boolean isSuccess=delete(num);
		
		if(isSuccess) {
			System.out.println("회원 정보를 삭제했습니다.");
		}else {
			System.out.println("삭제 실패!");
		}
	}
	
	// 매개 변수로 전달되는 회원의 정보를 이용해서 회원 한 명의 정보를 삭제하고 성공 여부를 리턴하는 메소드
	public static boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					DELETE FROM member
					WHERE num = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}
	}
}
