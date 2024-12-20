package test.mypac;

public class Computer {
	private Cpu c;
	private Memory m;
	private Ssd s;
	
	//생성자를 하나라도 정의하면 기본 생성자는 없어진다. 
	
	//생성자
	public Computer(Cpu c, Memory m, Ssd s) {
		this.c=c;
		this.m=m;
		this.s=s;
	}
}




