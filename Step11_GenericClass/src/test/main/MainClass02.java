package test.main;

import test.mypac.Apple;
import test.mypac.Pair;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 *  key 값을 어떤 type 으로 설정할지?
		 *  value 값을 어떤 type 으로 설정할지?
		 *  롤 결정해서 2가지의 generic 클래스를 지정해야 한다.
		 */
		Pair<String, Integer> p1 = new Pair<>("one", 100);
		String k1 = p1.getKey();
		Integer v1 = p1.getValue();
		
		Pair<String , Apple> p2 = new Pair<>("two", new Apple());
		String k2 = p2.getKey();
		Apple v2 = p2.getValue();
	}
}
