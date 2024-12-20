package test.auto2;

import test.auto.Car;
import test.auto.Engine;

public class MyCar extends Car{

	public MyCar(Engine engine) {
		super(engine);
	}
	
	public void myDrive() {
		// Car 클래스에 정의된 engine 이라는 필드는 접근 지정자가 protected 이기 때문에 
		// 페키지가 달라도 접근이 가능하다
		if(this.engine == null) {
			System.out.println("Engine 이 없어서 달릴수가 없어요!");
			return; //메소드를 여기서 리턴시키기(종료 시키기)
		}
		System.out.println("나만의 방식으로 달려요!");
	}
}
