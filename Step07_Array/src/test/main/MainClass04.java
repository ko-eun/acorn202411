package test.main;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainClass04 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
		//String type 이 저장되어 있는 배열 
		String[] data = {"🍒", "🍎", "🍌", "🍈", "7"};
		// 배열에 저장된 문자열중에 1개가 랜덤하게 콘솔창에 출력되도록 프로그래밍 해 보세요.
		Random ran=new Random();
		//나왔던 숫자를 저장할 배열 객체 생성
		int[] nums=new int[3];
		
		Scanner scan=new Scanner(System.in);
		//기본 점수 
		int score = 1000;
		
		while(true) {
			System.out.println("진행하려면 Enter 를 치세요");
			scan.nextLine();
			//score 를 10씩 감소 시키기 
			score -= 10;
			
			for(int j=0; j<20; j++) {
				
				for(int i=0; i<3; i++) {
					// 0~4 사이의 랜덤한 정수가 얻어내진다 
					int ranNum=ran.nextInt(5);
					System.out.print(data[ranNum]+" ");
					//나왔던 숫자를 배열에 순서대로 저장한다.
					nums[i]=ranNum;
				}
			}
			
			System.out.println();
			// 나왔던 랜덤한 정수가 모두 같으면 100 점, 하나라도 다르면 0 점을 출력해 보세요.
			if(nums[0] == nums[1] && nums[1] == nums[2]) {
				System.out.println("획득한 점수:100");
				score += 100;
			}else {
				System.out.println("획득한 점수:0");
			}
			System.out.println("score:"+score);
			if(score == 0) {
				System.out.println("Game Over!");
				break;
			}
		}
	}
	
}






