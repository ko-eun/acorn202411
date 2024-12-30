package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.DeptDto;
import test.dto.EmpDeptDto;
import test.util.DBConnector;

public class MainClass09 {
	public static void main(String[] args) {
		List<EmpDeptDto> list = getList();
		for(EmpDeptDto tmp:list) {
			System.out.printf("사원번호 : %d, 사원이름 : %s, 부서번호 : %d, 부서명 : %s \r\n", 
					tmp.getEmpno(), tmp.getEname(), tmp.getDeptno(), tmp.getDname());
			}
		}

	// 미리 준비한 메소드가 있다고 가정하면
	public static List<EmpDeptDto> getList(){
		// 여기에 어떻게 코딩하면 회원 목록(List<MemberDto>) 을 리턴해줄 수 있을까? 코딩해보세요.
		List<EmpDeptDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 우리가 설계한 클래스로 객체 생성 후 Connection 객체 얻어내기
			conn = new DBConnector().getConn();
			String sql = """
					SELECT empno, ename, deptno, dname
					FROM emp
					JOIN dept USING(deptno)
					ORDER BY deptno DESC
				""";
			
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					EmpDeptDto dto = new EmpDeptDto();
					dto.setEmpno(rs.getInt("empno"));
					dto.setEname(rs.getString("ename"));
					dto.setDeptno(rs.getInt("deptno"));
					dto.setDname(rs.getString("dname"));
					
					list.add(dto);
				}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
