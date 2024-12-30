package test.main;

import java.util.Scanner;

import test.dao.PostDao;
import test.dto.PostDto;

public class QuizMain04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("ID를 입력하세요.");
		int id = scan.nextInt();
		
		PostDao dao = new PostDao();
		PostDto dto = dao.getData(id);
		
		if(dto != null) {
			System.out.printf("ID : %d, 제목 : %s, 내용 : %s",
					dto.getId(), dto.getTitle(), dto.getContent());
		}else {
			System.out.printf("%d 번의 정보는 존재하지 않습니다", id);
		}
	}
}
