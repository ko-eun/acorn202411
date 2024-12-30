package test.main;

import java.util.Scanner;

import test.dao.PostDao;
import test.dto.PostDto;

public class QuizMain01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("제목 입력 : ");
		String title = scan.nextLine();
		System.out.println("내용 입력 : ");
		String content = scan.nextLine();
		
		PostDto dto = new PostDto();
		dto.setTitle(title);
		dto.setContent(content);
		
		PostDao dao = new PostDao();
		boolean isSuccess = dao.insert(dto);
		if(isSuccess) {
			System.out.printf("%s 에 대한 내용이 저장되었습니다.", title);
		}else {
			System.out.println("저장 실패!");
		}
	}
}
