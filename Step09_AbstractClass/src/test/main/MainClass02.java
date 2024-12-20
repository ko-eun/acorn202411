package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Tiger;

public class MainClass02 {
	public static void main(String[] args) {
		Zoo z1=new Zoo();
		
		Zoo.Monkey m1=z1.getMonkey();
		m1.say();
		
		Tiger t1=z1.getTiger();
		t1.say();
	}
}
