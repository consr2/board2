package com.board.question;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.result.Result;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QuestionController {
	
	private final QuestionService questionService;

	@PostMapping("/api/v1/question")
	public Long createQuestion(QuestionForm questionForm) {
		return questionService.createQuestion(questionForm);
	}
	
	@GetMapping("/api/v1/question")
	public Result getQuestionList(int page) {
		return questionService.getQuestionList(page);
	}
	
}
