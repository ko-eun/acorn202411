package test.mypac;

public class Player {
	
	//생성자
	public Player() {
		//객체를 생성하는 시점에 무언가 준비 작업을 하고 싶으면 여기서 한다.
		System.out.println("정신을 바짝차려요!");
		System.out.println("헬멧을 써요!");
	}
	
	//공격하는 메소드
	public void attack() {
		System.out.println("공격해요");
	}
	//움직이는 메소드
	public void move() {
		System.out.println("이동해요");
	}
}
