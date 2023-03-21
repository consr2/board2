package com.board.user;

import java.util.List;

import com.board.question.Question;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
	private List<Question> questionList;
	
	@Builder
	public void creatUser(String name, String password, String role) {
		this.name = name;
		this.password = password;
		this.role = Role.valueOf(role);
	}
	
}
