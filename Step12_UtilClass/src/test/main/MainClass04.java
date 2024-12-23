package test.main;

import java.util.ArrayList;
import java.util.function.Consumer;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type 을 저장할 수 있는 ArrayList 객체를 생성해서
		//참조값을 ArrayList type 지역변수 cars 에 담아보세요.
		ArrayList<Car> cars = new ArrayList<>();
		
		//2. Car 객체(3개)를 생성해서 ArrayList 객체에 저장해보세요.
		cars.add(new Car("벤츠"));
		cars.add(new Car("아우디"));
		cars.add(new Car("볼보"));
		
		//3. 일반 for 문을 이용해서 ArrayList 객체에 저장된 모든 Car 객체의 drive() 메소드를
		// 순서대로 호출해보세요.
		for(int i = 0; i<cars.size(); i++) {
			Car c=cars.get(i);
			c.drive();
		}
		
		//4. 확장 for 문을 이용해서 ArrayList 객체에 저장된 모든 Car 객체의 drive() 메소드를
		//순서대로 호출해보세요.
		for(Car c:cars) {
			c.drive();
		}
		
		//5. ArrayList 객체의 forEach() 메소드를 이용해서 ArrayList 객체에 저장된 모든 Car 객체의 drive()
		//메소드를 순서대로 호출해보세요.
		cars.forEach((c)->{
			c.drive();
		});
	}
}
