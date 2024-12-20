package test.main;
/*
 *  3. 비교연산자 테스트
 *     비교연산의 결과는 boolean type 을 리턴해준다. 
 *  ==, !=, >, >=, <, <= 
 */
public class MainClass03 {
	public static void main(String[] args) {
		//같은지 비교하는 연산자 ==
		boolean result1 = 10 == 10; //true
		//다른지 비교하는 연산자 !=
		boolean result2 = 10 != 10; //false
		boolean result3 = 10 > 100; //false;
		boolean result4 = 10 >= 10; //true
		boolean result5 = 10 < 100; //true
		boolean result6 = 10 <= 10; //true			
	}
}
