package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.SooniDto;
import test.util.DBConnector;

/*
 *  회원 정보를  insert, update, delete, select 할수 있는 기능을 가진 객체를 생성할 클래스 설계하기
 *  
 *  - 이런 기능을 가진 객체를 Data Access Object 라고 한다  DAO
 */
public class SooniDao {
	//매개 변수에 전달된 MemberDto 객체에 담긴 회원 한명의 정보를 DB 에 저장하는 메소드
	public boolean insert(SooniDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount=0;		
		try {
			conn=new DBConnector().getConn();
			//실행할 sql 문
			String sql="""
				INSERT INTO soonigroup
				(num, name, hiredate)
				VALUES(soonigroup_seq.NEXTVAL, ?, ?)	
			""";
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHiredate());
			//sql 문 실행
			rowCount=pstmt.executeUpdate();
		}catch(SQLException se) {
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
	//매개변수에 전달된 번호에 해당하는 회원 한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
				DELETE FROM soonigroup
				WHERE num=?
			""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setInt(1, num);
			//sql 문 실행
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	//매개 변수에 전달된 MemberDto 객체에 담긴 회원 한명의 정보를 수정하는 메소드
	public boolean update(SooniDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
				UPDATE soonigroup
				SET name=?, hiredate=?
				WHERE num=?
			""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHiredate());
			pstmt.setInt(3, dto.getNum());
			//sql 문 실행
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	//전체 회원 목록을 리턴하는 메소드
	public List<SooniDto> getList(){
		
		List<SooniDto> list=new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnector().getConn();
			String sql = """
				SELECT num, name, hiredate
				FROM soonigroup
				ORDER BY num ASC	
			""";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.

			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 
			while (rs.next()) {
				//MemberDto 객체를 생성해서 
				SooniDto dto=new SooniDto();
				//ResultSet 에 담긴 정보를 추출해서 MemberDto 객체에 담은 다음 
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setHiredate(rs.getString("hiredate"));
				//MemberDto 객체를 ArrayList 객체에 누적 시킨다.
				list.add(dto);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//회원정보가 누적된 ArrayList 객체를 리턴해준다.
		//select 된 row 가 없으면 list.size() 는 0 이다. 
		return list;
	}
	//매개변수에 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public SooniDto getData(int num) {
		
		SooniDto dto=null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnector().getConn();
			String sql="""
				SELECT name, hiredate
				FROM soonigroup
				WHERE num=?	
			""";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				dto=new SooniDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setHiredate(rs.getString("hiredate"));
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