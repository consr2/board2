package com.board.question;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.board.like.Likes;
import com.board.like.LikesRepository;
import com.board.result.Result;
import com.board.user.Users;
import com.board.user.UsersRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

	private final QuestionRepository questionRepository;
	private final UsersRepository usersRepository;
	private final LikesRepository likesRepository;
	
	//글 작성
	public Long createQuestion(QuestionForm questionForm, HttpServletRequest request) {
		String name = (String) request.getAttribute("name");
		Users user = usersRepository.findByName(name).get();
		
		Question q = new Question(questionForm, user);
		return questionRepository.save(q).getId();
	}

	//글목록 리턴
	public Result getQuestionList(int page, HttpServletRequest request) {
		Pageable pageable = PageRequest.of(page, 5, Direction.DESC, "id");
		List<QuestionDto> collect = questionRepository.allListPage(pageable)
				.stream().map(m -> new QuestionDto(m, request.getAttribute("name").toString()))
				.collect(Collectors.toList());
		
		return new Result<>(collect.size(), collect);
	}

	public String addLike(Long id, HttpServletRequest request) {
		String name = (String) request.getAttribute("name");
		Question question = questionRepository.findById(id).get();
		Optional<Likes> olike = likesRepository.findByUsernameAndQuestion(name, question);
		if(olike.isEmpty()) {
			Likes like = new Likes(name, question);
			likesRepository.save(like).getId();
			return likesRepository.save(like).getId().toString();
		}
		return "이미 추천하였습니다";
	}
}
