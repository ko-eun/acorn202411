package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class QuizMain {
	public static void main(String[] args) {
		//1. 정수를 담을 수 있는 ArrayList 객체를 생성해서 nums 라는 지역 변수에 담아보세요.
		List<Integer> nums = new ArrayList<>();
		
		//2. 반복문 10 번 돌면서 1~100 사이의 랜덤한 정수를 각각 얻어내서 
		// 위에서 생성한 nums 객체에 순서대로 담아보세요.
		
		// 랜덤한 정수를 얻어낼 객체
		Random R = new Random();
		//반복문 10번 돌도록 구성
		for(int i = 0; i<10; i++) {
			// 1~100 사이의 랜덤한 정수 얻어내기
			int ranNum= R.nextInt(100)+1;
			nums.add(ranNum);
		}
		
		//3. nums 에 저장된 숫자에서 중복된 숫자가 제거된 새로운 ArrayList 객체를 얻어내보세요.
		Set<Integer> set = new HashSet<>();
		// Set 객체에 숫자를 넣으면 중복이 제거된다.
		nums.forEach((item)->{
			set.add(item);
		});
		
		// 중복이 제거된 Set 을 이용해서 다시 ArrayList 객체 생성
		List<Integer> result = new ArrayList<>();
		
		//4. 새로운 배열에 숫자를 오름차순 정렬해보세요.
		Collections.sort(result);
		
		//5. 새로운 배열에 저장된 숫자를 순서대로 콘솔창에 출력해보세요.
		result.forEach((item)->{
			System.out.println(item);
		});
	}
}
