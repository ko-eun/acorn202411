package test.main;

import test.dao.PostDao;
import test.dto.PostDto;

public class QuizMain03 {
	public static void main(String[] args) {
		PostDto dto = new PostDto();
		dto.setId(1);
		
		var dao = new PostDao();
		
		var isSuccess = dao.delete(1);
		
		if(isSuccess) {
			System.out.println("회원 정보를 삭제했습니다.");
		}else {
			System.out.println("삭제 실패!");
		}
	}
}
