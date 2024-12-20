package test.main;

import test.mypac.AndroidPhone;
import test.mypac.Phone;

public class MainClass08 {
	public static void main(String[] args) {
		
		//여기서 아래의 usePhone() 메소드를 호출하는 code 를 작성하고 run 해서 결과를 확인해 보세요!
		
		//메소드 호출과 동시에 객체를 생성해서 전달 
		MainClass08.usePhone(new Phone());
		
		//미리 생성된 객체의 참조값을 
		Phone p1=new Phone();
		//참조해서 전달
		MainClass08.usePhone(p1);
		
		//클래스명 생략가능
		usePhone(p1);
		
		//자식 type 객체를 전달해도 된다. 
		usePhone(new AndroidPhone());
		
	}
	//static 메소드 추가 (이 메소드를 호출하기 위해서는 Phone type 의 참조값이 필요하다)
	public static void usePhone(Phone p) {
		//매개변수에 전달된 값을 이용해서 메소드를 호출하는 code
		p.call();
	}
}







