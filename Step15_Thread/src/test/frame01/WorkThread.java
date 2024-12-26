package test.frame01;
/*
 *  새로운 스레드 만드는 방법
 *  
 *  1. Thread 클래스를 상속 받은 클래스를 정의한다.
 *  2. run() 메소드를 오버라이드한다.
 *  3. run() 메소드 안에서 새로운 스레드에서 해야 할 작업을 코딩한다.
 *  4. 만든 클래스로 객ㅊ를 생성하고 해당 객체의 start() 메소드를 호출하면 새로운 스레드가
 *     시작된다.
 */
public class WorkThread extends Thread{ //1.
	@Override
	public void run() {
		// 새로운 스레드에서 해야할 작업을 run() 메소드 안에서 한다
		System.out.println("10초 걸리는 작업을 시작합니다.");
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("작업이 종료되었습니다.");
	}
}
