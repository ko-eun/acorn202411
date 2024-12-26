package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * C:/Users/acorn/OneDrive/Desktop/playground/myFolder/memo.txt 파일에 저장된 문자열을 읽어와서
 * 콘솔창에 출력하는 예쩨
 */
public class MainClass09 {
	public static void main(String[] args) {
		File f = new File("C:/Users/acorn/OneDrive/Desktop/playground/myFolder/memo.txt");
		
		try {
			// 파일로부터 문자열을 읽어 들일 수 있는 객체 생성
			var fr = new FileReader(f);
			// 문자열을 줄단위로 읽어들일 수 있는 객체
			var br = new BufferedReader(fr);
			// 무한 루프 돌면서
			while(true) { 
				String line = br.readLine();
				// 더 이상 읽어 올 문자열이 없으면 반복문 탈출
				if(line == null) {
					break;
				}
				// 읽어온 문자열을 한 줄씩 콘솔창에 출력
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
