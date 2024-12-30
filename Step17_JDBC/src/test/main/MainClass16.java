package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass16 {
	public static void main(String[] args) {
		/*
		 *  MemberDao 객체를 이용해서 1번 회원의 정보를 삭제해보세요.
		 *  성공 여부 콘솔창 출력
		 */
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		
		var dao = new MemberDao();
		
		var isSuccess=dao.delete(1);
		
		if(isSuccess) {
			System.out.println("회원 정보를 삭제했습니다.");
		}else {
			System.out.println("삭제 실패!");
		}
	}
}
