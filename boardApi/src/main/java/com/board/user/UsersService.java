package com.board.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
	
	private final UsersRepository usersRepository;
	
	//페스워드 해싱처리
	public String passwordEncode(String password) {
		MessageDigest sha256 = null;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		sha256.update(password.getBytes());
		byte[] pass = sha256.digest();
		
		StringBuffer sb = new StringBuffer();
		for(byte b : pass) {
			sb.append(String.format("%02x", b));
		}
		
		return sb.toString();
	}
	
	//회원가입
	public String createUser(UsersForm usersForm) {
		Optional<Users> ouser = usersRepository.findByName(usersForm.getName());
		
		if(ouser.isEmpty()) {
			String password = passwordEncode(usersForm.getPassword());
			
			Users user = new Users();
			user.builder()
				.name(usersForm.getName())
				.password(password)
				.role("ROLE_USER")
				.build();
			
			return usersRepository.save(user).getId().toString();
		}else {
			return "이미 존재하는 아이디 입니다";
		}
		
	}
	
	//로그인
	public String login(UsersForm usersForm, HttpServletRequest request) {
		Optional<Users> ouser = usersRepository.findByName(usersForm.getName());
		if(ouser.isPresent()) {
			String pw1 = ouser.get().getPassword();
			String pw2 = passwordEncode(usersForm.getPassword());
			if(pw1.equals(pw2)) {
				HttpSession session = request.getSession();
				session.setAttribute("name", usersForm.getName());
				session.setAttribute("auth", ouser.get().getRole().value());
				return "로그인 성공";
			}else {
				return "비밀번호가 다릅니다";
			}
		}else {
			return "아이디를 찾을 수 없습니다";
		}
	}

	//로그아웃
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "로그아웃 (세선삭제) 세션없는데 실행시 오류";
	}

}
