package com.board.question;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	@Query("select q from Question q left join fetch q.likeList l "
			+ "left join fetch q.users u")
	List<Question> allListPage(Pageable page);
	
	Page<Question> findAll(Pageable page);
	
}
