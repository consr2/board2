package com.board.question;

import lombok.Getter;

@Getter
public class QuestionDto {
	private String title;
	private String content;
	private String user;
	private int likecount;
	private boolean likecheck;
	
	public QuestionDto(Question question) {
		this.title = question.getTitle();
		this.content = question.getContent();
		this.user = question.getUsers().getName();
		this.likecount = question.getLikeList().size();
	}
}
