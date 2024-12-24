package test.main;
/*
 *  run 했을 때 콘솔창에
 *  
 *  1초
 *  2초
 *  3초
 *  .
 *  .
 *  경과 시간이 출력 되다가
 * 	.
 * 	.
 *  10초
 *  까지만 출력하고 종료되는 프로그래밍을 해보세요.
 *  hint => Thread.sleep(1000);
 */
public class QuizMain {
	public static void main(String[] args) {
		
		System.out.println("시작!");
		
		for (int i = 0 ; i<10 ; i++) {
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i+1+"초");
		}
		System.out.println("종료!");
	}
}
