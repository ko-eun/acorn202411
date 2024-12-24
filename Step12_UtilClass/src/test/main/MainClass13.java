package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass13 {
	public static void main(String[] args) {
		// 중복 허용하지 않는 Set 에 숫자를 담으면 중복이 제거된다.
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(10);
		set.add(20);
		set.add(20);
		set.add(30);
		set.add(20);
		set.add(40);
		
		// 중복이 제거된 Set 를 ArrayList 객체의 생성자에 전달해서 객체 생성하기
		List<Integer> list = new ArrayList<>(set);
		
		// 저장된 숫자를 오름차순으로 정렬
		Collections.sort(list);
		
		// 내림차순
		// Collections.sort(list, Collections.reverseOrder());
		
		list.forEach((item)->{
			System.out.println(item);
		});
	}
}
