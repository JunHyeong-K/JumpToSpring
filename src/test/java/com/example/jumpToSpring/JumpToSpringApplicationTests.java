package com.example.jumpToSpring;

import com.example.jumpToSpring.question.repository.QuestionRepository;
import com.example.jumpToSpring.question.domain.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
class JumpToSpringApplicationTests {



	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testCrud() {
		//given
		Question q1 = new Question();
		q1.setSubject("이게맞나");
		q1.setContent("아 시발 ㅈㄴ 간단하네");
		q1.setCreateTime(LocalDateTime.now());

		//when
		Question savedData = questionRepository.save(q1);

		//then
		Assertions.assertThat(q1.getSubject()).isEqualTo("이게맞나");
	}

}
