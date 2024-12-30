package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.DeptDto;
import test.dto.EmpDto;
import test.util.DBConnector;

public class MainClass08 {
	public static void main(String[] args) {
		// 사원 목록을 아주 쉽게 얻어낼 수 있다. (날로 먹을 수 있다)
				List<DeptDto> list = getList();
				for(DeptDto tmp:list) {
					System.out.printf("부서번호 : %d, 부서명 : %s, 지역 : %s \r\n", 
							tmp.getDeptno(), tmp.getDname(), tmp.getLoc());
					}
				}

			// 미리 준비한 메소드가 있다고 가정하면
			public static List<DeptDto> getList(){
				// 여기에 어떻게 코딩하면 회원 목록(List<MemberDto>) 을 리턴해줄 수 있을까? 코딩해보세요.
				List<DeptDto> list = new ArrayList<>();
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					// 우리가 설계한 클래스로 객체 생성 후 Connection 객체 얻어내기
					conn = new DBConnector().getConn();
					String sql = """
							SELECT deptno, dname, loc
							From dept
							ORDER BY deptno DESC
						""";
					
						pstmt = conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						while(rs.next()) {
							int deptno = rs.getInt("deptno");
							String dname = rs.getString("dname");
							String loc = rs.getString("loc");
							
							DeptDto dto = new DeptDto();
							dto.setDeptno(deptno);
							dto.setDname(dname);
							dto.setLoc(loc);
							
							list.add(dto);
						}
								
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
	}
}
