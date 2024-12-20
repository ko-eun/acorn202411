package test.main;

import java.io.PrintStream;

public class MainClass08 {
	
	//static 필드 
	public static String myName="김구라";
	//non static 필드
	public String yourName="에이콘";
	
	public static void main(String[] args) {
		// System 클래스의 out 이라는 statc 필드에는 콘솔창에 출력하는 기능을 가지고 있는 PrintStream type
		// 의 참조값이 들어 있다. 
		
		PrintStream a = System.out;
		a.println("오잉?");
		
		System.out.println(MainClass08.myName);
		System.out.println(myName);
		
		// yourName 은 static 필드가 아니라 참조가 안된다.
		//System.out.println(MainClass08.yourName);
		
		// 여기는 static 메소드 안쪽이기 때문에 this. 을 사용할수가 없다.
		//System.out.println(this.yourName);
		
		long time = System.currentTimeMillis();
		
		System.out.println("경과시간:"+time);
		
	}
	
	
}








