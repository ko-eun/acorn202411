package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass11 {
	public static void main(String[] args) {
		int num = 1;
		String name = "고은미";
		String addr = "화정동";
		
		MemberDto dto=new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		boolean isSuccess=update(dto);
		
		if(isSuccess) {
			System.out.println("회원 정보를 수정했습니다.");
		}else {
			System.out.println("수정 실패!");
		}
	}
	
	/*
	 *  수정할 회원의 정보(번호, 이름, 주소) 가 MemberDto 객체에 담겨서 전달되는 메소드
	 *  성공여부가 리턴되는 메소드
	 */
	public static boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					UPDATE member
					SET name =?, addr = ?
					WHERE num = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			rowCount = pstmt.executeUpdate();
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
