package test.main;

import test.mypac.Car;

public class MainClass02 {
	public static void main(String[] args) {
		//Car 객체를 생성해서 참조값을 car1 이라는 지역 변수에 담아 보세요
		Car car1=new Car();
		// car1 안에 들어 있는 값을 활용해서 name 이라는 필드에 "소나타" 를 대입해 보세요.
		car1.name="소나타";
		// car1 안에 들어 있는 값을 활용해서 price 라는 필드에 2000 을 대입해 보세요.
		car1.price=2000;
	}
}
