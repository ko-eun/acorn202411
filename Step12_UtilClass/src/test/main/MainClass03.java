package test.main;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MainClass03 {
	public static void main(String[] args) {
		// 인사말을 담을 ArrayList 객체를 생성해서 참조값을 greets 라는 지역 변수에 대입하기
		ArrayList<String> greets = new ArrayList<>();
		// greets 에 들어있는 참조값을 이용해서 인사말 3개를 임의로 담아보세요
		greets.add("안녕하세요");
		greets.add("Hi");
		greets.add("Hello");
		
		// 확장 for 문을 이용해서 모든 인사말을 콘솔창에 순서대로 출력해보세요.
		for(String a : greets) {
			System.out.println(a);
		}
		
		System.out.println("--------");
		
		Consumer<String> con = new Consumer<String>() {
			
			@Override
			public void accept(String a) {
				System.err.println(a);
			}
		};
				
		greets.forEach(con);
	}
}
