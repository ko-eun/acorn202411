package test.main;

import java.util.List;

import test.dao.PostDao;
import test.dto.PostDto;

public class QuizMain05 {
	public static void main(String[] args) {
		List<PostDto> list = new PostDao().getList();
		for(PostDto tmp:list) {
			System.out.printf("ID : %d, 제목 : %s, 내용 : %s \r\n",
					tmp.getId(), tmp.getTitle(), tmp.getContent());
		}
	}
}
