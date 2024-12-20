package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		//1. 콘솔창에 "main 메소드가 시작되었습니다." 를 출력해 보세요.
		System.out.println("main 메소드가 시작되었습니다.");
		//2. 국어점수 95 를 kor 이라는 변수에 담아보세요.
		int kor=95;
		//3. 영어점수 100 을 eng 라는 변수에 담아보세요.
		int eng=100;
		//4. 국어 점수와 영어 점수의 평균을 구해서(연산자 활용) avg 라는 변수에 담아 보세요.
		double avg=(kor+eng)/2d; //정수끼리 연산하면 결과는 정수만 나오기 때문에 2 옆에 d 를 붙여서 실수로 만들어준다.
		//5. 콘솔창에 avg 변수안에 담긴 내용을 출력해 보세요.
		System.out.println(avg);
	}
}
