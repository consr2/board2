package com.board.question;

import com.board.like.Likes;

import lombok.Getter;

@Getter
public class QuestionDto {
	private String title;
	private String content;
	private String user;
	private int likecount;
	private boolean likecheck;
	
	public QuestionDto(Question question, String user) {
		this.title = question.getTitle();
		this.content = question.getContent();
		this.user = question.getUsers().getName();
		this.likecount = question.getLikeList().size();
		for(Likes like : question.getLikeList()) {
			if(like.getUsername().equals(user)) {
				this.likecheck = true;
				break;
			}
		}
		
	}
}
