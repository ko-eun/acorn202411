package test.main;

import java.util.ArrayList;

import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		//1. Member 객체를 담을 수 있는 ArrayList 객체를 생성해서 참조값을 members 라는
		// List type 지역변수에 담아보세요.
		ArrayList<Member> members = new ArrayList<>();
		
		//2. 3명의 회원정보를 Member 객체에 각각 담아보세요. (Member 객체가 3개 생성되어야 함)
		members.add(new Member(1,"고은미","화정동"));
		members.add(new Member(2,"차수빈","진월동"));
		members.add(new Member(3,"노유정","화순"));
		
		//3. 위에서 생성된 Member 객체의 참조값을 List 객체에 모두 담아보세요.
		// 2번에 한 번에 해버림
		
		/*
		 * 4. members List 객체에 담긴 내용을 이용해서 회원목록을 아래와 같은 형식으로
		 *  반복문 돌면서 출력해보세요.
		 *  
		 *  번호 : 1, 이름 : 김구라, 주소 : 노량진
		 *  번호 : 2, 이름 : 해골, 주소 : 행신동 
		 */
		for(Member m:members) {
			// String 클래스의 format() 이라는 static 메소드를 이용해서 원하는 문자열 형식을 만든 다음
			String info = String.format("번호 : %d, 이름 : %s, 주소 : %s", m.num, m.name, m.addr);
			// 콘솔창에 출력하기
			System.out.println(info);
		}
	}
}
