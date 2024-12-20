package test.main;

import java.util.Scanner;

public class MainClass04 {
	public static void main(String[] args) {
		//콘솔창으로 부터 입력받을수 있는 Scanner 객체 생성
		Scanner scan=new Scanner(System.in);
		// .print() 메소드는 개행기호를 출력하지 않는다.
		System.out.print("첫번째숫자:");
		String a = scan.nextLine();
		
		System.out.println();
		
		System.out.print("두번째숫자:");
		String b = scan.nextLine();
		
		// 문자열을 실제 숫자로 바꿔서 연산한다.
		double result = Double.parseDouble(a) + Double.parseDouble(b);
		
		System.out.print("두수의 합은:"+result);
		
	}
}









