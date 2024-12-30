package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass13 {
	public static void main(String[] args) {
		int num=1; //select 해야할 회원의 번호라고 가정
		
		//미리 준비된 메소드를 호출하면서 회원번호를 전달하고 해당하는 회원 정보를 리턴 받는다.
		MemberDto dto=getData(num);
		
		if(dto != null) {
			System.out.printf("번호:%d 이름:%s 주소:%s", 
					dto.getNum(), dto.getName(), dto.getAddr());
		}else {
			System.out.printf(" %d 회원의 정보는 존재하지 않습니다.", num);
		}
	}
	/*
	 *  매개 변수로 전달되는 번호에 해당하는 회원 정보를 select 해서 
	 *  MemberDto 객체에 담아서 리턴해주는 메소드 
	 */
	public static MemberDto getData(int num) {
		
		MemberDto dto=null;
		
		//필요한 객체를 담을 지역변수 미리 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnector().getConn();
			String sql="""
				SELECT name, addr
				FROM member
				WHERE num=?	
			""";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			//만일 select 된 row 가 있다면 
			if(rs.next()) {
				//MemberDto 객체를 생성해서 
				dto=new MemberDto();
				//select 된 정보를 담는다.
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return dto;
	}
}
