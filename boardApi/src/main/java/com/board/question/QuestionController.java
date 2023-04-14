package com.board.question;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.result.Result;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QuestionController {
	
	private final QuestionService questionService;

	@PostMapping("/api/v1/question")
	public Long createQuestion(QuestionForm questionForm, HttpServletRequest request) {
		return questionService.createQuestion(questionForm, request);
	}
	
	@GetMapping("/api/v1/question")
	public Result getQuestionList(@RequestParam(value="page", defaultValue="0") int page
		, HttpServletRequest request) {
		return questionService.getQuestionList(page, request);
	}
	
	@PostMapping("/api/v1/question/like/{id}")
	public String addLike(@PathVariable("id") Long id,  HttpServletRequest request) {
		return questionService.addLike(id, request);
	}
	
	@DeleteMapping("/api/v1/question/{id}")
	public String deleteQuestion(@PathVariable("id") Long id, HttpServletRequest request) {
		return questionService.deleteQuestion(id, request);
	}
}
