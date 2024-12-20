package test.main;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		
		Car car1=new Car();
		car1.drive();
		//Car 객체를 생성해서 메소드 호출하고 참조값은 더이상 사용할수 없다. 
		new Car().drive();
		
		car1.drive();
		car1.drive();
		
	}
}
