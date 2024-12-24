package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.mypac.MemberDto;

public class MainClass09 {
	private static final int ArrayList = 0;

	public static void main(String[] args) {
		// 1. 세 명의 회원정보(번호, 이름, 주소) 를 HashMap 객체를 생성해서 담아보세요.
		// HashMap 객체 하나당 한 명의 회원 정보를 담으니까 총 HashMap 객체가 생성이 되어야 합니다.
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("m1", new MemberDto(1,"고은미","화정동"));
		map.put("m2", new MemberDto(2,"차수빈","진월동"));
		map.put("m3", new MemberDto(3,"노유정","화순읍"));
		
		// 2. 위에서 생성한 HashMap 객체를 담을 ArrayList 객체를 생성해보세요.
	//		List<<Map<String, Object>> list = ArrayList<>();
		
		// 3. ArrayList 객체에 HashMap 객체 3개를 담아보세요.
	//	list.add(map1);
	//	//list.add(map2);
		// 4. 반복문을 돌리면서 ArrayList 에 담긴 회원정보를 콘솔창에 이쁘게 출력해보세요.
	//		for(Map<String,Object> tmp : list) {
	//			String info = String.format("번호 : %d, 이름 : %s, 주소 : %s", tmp.get("num"), tmp.get("name"), tmp.get("addr"));
	//			System.out.println(info);
		}
	}
//}
