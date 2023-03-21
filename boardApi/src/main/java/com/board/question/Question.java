package com.board.question;

import java.util.List;

import com.board.like.Likes;
import com.board.user.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String content;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Likes> likeList;
	
	@ManyToOne
	private Users users;
	
	public Question(QuestionForm questionForm, Users user) {
		this.title = questionForm.getTitle();
		this.content = questionForm.getContent();
		this.users = user;
	}
}
