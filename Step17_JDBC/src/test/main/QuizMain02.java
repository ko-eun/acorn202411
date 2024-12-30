package test.main;

import test.dao.PostDao;
import test.dto.PostDto;

public class QuizMain02 {
	public static void main(String[] args) {
		int id = 1;
		String title = "싱가포르";
		String content = "싱가포르";
		
		PostDto dto = new PostDto();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		
		PostDao dao = new PostDao();
		dao.update(dto);
		
		boolean isSuccess=dao.update(dto);
		
		if(isSuccess) {
			System.out.println("회원 정보를 수정했습니다.");
		}else {
			System.out.println("수정 실패!");
		}
	}
}
