package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		try {
			// 스레드를 일정시간 지연시키기(mili second 단위로 숫자를 전달하면 된다.)
			Thread.sleep(1000*5); 
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료됩니다");
	}
}	
