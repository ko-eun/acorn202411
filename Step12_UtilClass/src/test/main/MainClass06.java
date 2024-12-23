package test.main;

import java.util.ArrayList;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		//1. MemberDto 객체를 담을 수 있는 ArrayList 객체를 생성해서 참조값을 members 라는
		// 지역변수에 담아보세요.
		ArrayList<MemberDto> members = new ArrayList<>();
		
		//2. 3명의 회원정보를 MemberDto 객체에 각각 담아보세요. (MemberDto 객체가 3개 생성)
		members.add(new MemberDto(1,"고은미","화정동"));
		members.add(new MemberDto(2,"차수빈","진월동"));
		members.add(new MemberDto(3,"노유정","화순"));
		
		//3. 위에서 생성된 MemberDto 객체의 참조값을 ArrayList 객체에 담아보세요.
		
		//4. 반복문을 이용해서 members 에 들어있는 회원정보를 출력해보세요.
		for(MemberDto m:members) {
			System.out.println("번호 : "+m.getNum()+" 이름 : "+m.getName()+" 주소 : "+m.getAddr());
		}
		
		// 테스트 메소드 호출 (매개 변수에 전달할 String type 의 갯수는 유동적이다)
		test();
		test("kim");
		test("kim","lee","park");
	}
	
	// ... 테스트
	
	public static void test(String... msgs) {
		// String...은  Strig[] type 이다
		String[] a= msgs;
	}
}
