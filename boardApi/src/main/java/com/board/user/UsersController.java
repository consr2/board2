package com.board.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UsersController {

	private final UsersService usersService;
	
	@PostMapping("/api/v1/user")
	public String createUser(UsersForm usersForm) {
		return usersService.createUser(usersForm);
	}
	
	@GetMapping("/api/v1/login")
	public String login(UsersForm usersForm, HttpServletRequest request) {
		return usersService.login(usersForm, request);
	}
	
	@GetMapping("/api/v1/logout")
	public String logout(HttpServletRequest request) {
		return usersService.logout(request);
	}
	
	@GetMapping("/api/v1/auth")
	public String authcheck() {
		return "권한이 없습니다";
	}
	
}
