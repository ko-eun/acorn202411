package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		// 상수(Read Only) 를 만들때는 final 이라는 예약어를 type 선언 앞에 붙여주면 된다.
		// 관례상 상수를 만들때는 모두 대문자로 표기한다 
		final int MY_ID=999;
		// 어떤 type 이든 상관없이 상수로 만들수 있다. 
		final String MY_NAME="김구라";
		
		System.out.println(MY_ID);
		System.out.println(MY_NAME);
		
		//값 변경 불가 
		//MY_ID=888;
		//MY_NAME="해골";
		
	}
}
