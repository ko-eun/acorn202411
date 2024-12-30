package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.dto.PostDto;
import test.util.DBConnector;

public class PostDao {
	public boolean insert(PostDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount=0;		
		try {
			conn=new DBConnector().getConn();
			//실행할 sql 문
			String sql="""
				INSERT INTO posts
				(id, title, content)
				VALUES(posts_seq.NEXTVAL, ?, ?)	
			""";
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
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
	
	public boolean update(PostDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
				UPDATE posts
				SET title=?, content=?
				WHERE id=?
			""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getId());
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
	
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
				DELETE FROM posts
				WHERE id=?
			""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setInt(1, id);
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
	
public List<PostDto> getList(){
		
		List<PostDto> list=new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnector().getConn();
			String sql = """
				SELECT id, title, content
				FROM posts 
				ORDER BY id ASC	
			""";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.

			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 
			while (rs.next()) {
				//MemberDto 객체를 생성해서 
				PostDto dto=new PostDto();
				//ResultSet 에 담긴 정보를 추출해서 MemberDto 객체에 담은 다음 
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
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

	public PostDto getData(int id) {
		
		PostDto dto=null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnector().getConn();
			String sql="""
				SELECT title, content
				FROM posts
				WHERE id=?	
			""";
			pstmt=conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.
			pstmt.setInt(1, id);
			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs=pstmt.executeQuery();
			//만일 select 된 row 가 있다면
			if(rs.next()) {
				dto=new PostDto();
				dto.setId(id);
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
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
		// select 된 정보가 없으면 dto 는 null 이다 
		return dto;
}
}
