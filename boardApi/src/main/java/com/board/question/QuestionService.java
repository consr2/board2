package com.board.question;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.board.result.Result;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
@RequiredArgsConstructor
public class QuestionService {

	private final QuestionRepository questionRepository;
	
	public Long createQuestion(QuestionForm questionForm) {
		Question q = new Question(questionForm);
		return questionRepository.save(q).getId();
	}

	public Result getQuestionList(int page) {
		Pageable pageable = PageRequest.of(page, 5, Direction.DESC, "id");
		List<QuestionDto> collect = questionRepository.findAll(pageable)
				.stream().map(QuestionDto::new).collect(Collectors.toList());
		return new Result<>(collect.size(), collect);
	}
}
