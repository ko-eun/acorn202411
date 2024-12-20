package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	public static void main(String[] args) {
		// 인터페이스도 익명 클래스를 활용해서 구현 후에 참조값을 얻어낼 수 있다.
		Remocon r1 = new Remocon() {

			@Override
			public void up() {
				System.out.println("채널을 올려요!");
				
			}

			@Override
			public void down() {
				System.out.println("채널을 내려요!");
				
			}
			
		};
		
		// 메소드 호출하면서 지역 변수에 담겨져 있는 Remocon type 의 참조값을 전달
		useRemocon(r1);
		
		// 메소드 호출하면서 즉석에서 Remocon type 참조값을 얻어내서 전달
		useRemocon(new Remocon() {
			
			@Override
			public void up() {
				System.out.println("밝기를 올려요!");
			}
			
			@Override
			public void down() {
				System.out.println("밝기를 내려요!");
			}
		});
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
