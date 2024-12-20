package test.main;

import java.util.Random;

public class MainClass02 {
	public static void main(String[] args) {
		//Random 객체를 생성해서 Random type 지역변수에 담기 
		Random ran=new Random();
		//Random 객체를 이용해서 0~9 사이의 랜덤한 정수 얻어내기 
		int num=ran.nextInt(10);
		System.out.println(num);
		
		//1~45 사이의 랜덤한 정수 얻어내기
		int lottoNum=ran.nextInt(45)+1;
	}
}
