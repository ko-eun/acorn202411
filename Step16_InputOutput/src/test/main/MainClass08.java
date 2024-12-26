package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * C:/Users/acorn/OneDrive/Desktop/playground/myFolder/memo.txt 파일에 저장된 문자열을 읽어와서
 * 콘솔창에 출력하는 예쩨
 */
public class MainClass08 {
	public static void main(String[] args) {
		File f = new File("C:/Users/acorn/OneDrive/Desktop/playground/myFolder/memo.txt");
		
		try {
			// 파일로부터 문자열을 읽어 들일 수 있는 객체 생성
			var fr = new FileReader(f);
			// 무한 루프 돌면서
			while(true) { 
				// 문자의 코드값을 읽어 들인다.
				int code = fr.read();
				// 만일 더 이상 읽을 게 없다면 
				if(code == -1) {
					break; // 반복문 탈출
				}
				// 코드를 문자로 변환
				char ch = (char)code;
				// 출력
				System.out.println(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
