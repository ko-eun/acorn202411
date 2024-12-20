package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 *  Remocon 인터페이스는 data type 의 역활을 할수 있는데 
		 *  해당 type 의 참조값을 얻어내기 위해서는 인터페이스를 구현한 클래스로 
		 *  객체 생성을 하면 된다.
		 */
		Remocon r1=new MyRemocon();
		r1.up();
		r1.down();
		
		// Remocon 인터페이스에 정의된 static final 상수 참조
		String result = Remocon.COMPANY; // "LG"
		
		// Final 상수이기 때문에 수정 불가
		// Remocon.COMPANY = "SAMSUNG";
	}
}
