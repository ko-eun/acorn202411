package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.EmpDto;
import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass07 {
	public static void main(String[] args) {
		// 사원 목록을 아주 쉽게 얻어낼 수 있다. (날로 먹을 수 있다)
			List<EmpDto> list = getList();
			for(EmpDto tmp:list) {
				System.out.printf("사원번호 : %d, 사원이름 : %s, 직업 : %s, 급여 : %f \r\n", 
						tmp.getEmpno(), tmp.getEname(), tmp.getJob(), tmp.getSal());
			}
		}

	// 미리 준비한 메소드가 있다고 가정하면
	public static List<EmpDto> getList(){
		// 여기에 어떻게 코딩하면 회원 목록(List<MemberDto>) 을 리턴해줄 수 있을까? 코딩해보세요.
		List<EmpDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 우리가 설계한 클래스로 객체 생성 후 Connection 객체 얻어내기
			conn = new DBConnector().getConn();
			String sql = """
					SELECT empno, ename, job, sal
					FROM emp
					ORDER BY empno ASC
				""";
			
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					double sal = rs.getDouble("sal");
					
					EmpDto dto = new EmpDto();
					dto.setEmpno(empno);
					dto.setEname(ename);
					dto.setJob(job);
					dto.setSal(sal);
					
					list.add(dto);
				}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
