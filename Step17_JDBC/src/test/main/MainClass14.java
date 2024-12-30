package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		// 이름과 주소를 Scanner 객체로 입력 받아서 DB 에 저장하는 프로그래밍
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		String name = scan.nextLine();
		System.out.println("주소 입력 : ");
		String addr = scan.nextLine();
		
		// 입력한 이름과 주소를 MemberDto 객체에 담기
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		MemberDao dao = new MemberDao();
		boolean isSuccess = dao.insert(dto);
		if(isSuccess) {
			System.out.printf("%s 님의 정보가 저장되었습니다.", name);
		}else {
			System.out.println("저장 실패");
		}
	}
}
