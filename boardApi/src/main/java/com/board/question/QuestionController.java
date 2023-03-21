package com.board.question;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.result.Result;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QuestionController {
	
	private final QuestionService questionService;

	@PostMapping("/api/v1/question")
	public Long createQuestion(QuestionForm questionForm, HttpSession session) {
		return questionService.createQuestion(questionForm, session);
	}
	
	@GetMapping("/api/v1/question")
	public Result getQuestionList(int page) {
		return questionService.getQuestionList(page);
	}
	
	@PostMapping("/api/v1/question/like/{id}")
	public String addLike(@PathVariable("id") Long id,  HttpSession session) {
		return questionService.addLike(id,session);
	}
}
