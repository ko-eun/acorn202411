package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass15 {
	public static void main(String[] args) {
		/*
		 *  MemberDao 객체를 이용해서 
		 *  1번 회원의 이름을 "김구라", 주소를 "노량진" 으로 수정해보세요.
		 *  단) 성공 여부를 콘솔창에 출력
		 */
		int num = 1;
		String name = "김구라";
		String addr = "노량진";
		
		MemberDto dto = new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		MemberDao dao = new MemberDao();
		dao.update(dto);
		
		boolean isSuccess=dao.update(dto);
		
		if(isSuccess) {
			System.out.println("회원 정보를 수정했습니다.");
		}else {
			System.out.println("수정 실패!");
		}
	}
}
