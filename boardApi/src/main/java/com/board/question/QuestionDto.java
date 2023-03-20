package com.board.question;

import lombok.Getter;

@Getter
public class QuestionDto {
	private String title;
	private String content;
	
	public QuestionDto(Question question) {
		this.title = question.getTitle();
		this.content = question.getContent();
	}
}
