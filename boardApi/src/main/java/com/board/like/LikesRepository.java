package com.board.like;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.question.Question;

public interface LikesRepository extends JpaRepository<Likes, Long>{
	Optional<Likes> findByUsernameAndQuestion(String name, Question question);
}
