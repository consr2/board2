package com.board.intercepter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;

import com.board.user.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class IntercepterCheck {

	private List<Pathinfo> list = new ArrayList<>();
	
	//url 등록
	public IntercepterCheck(){
		this.list.add(new Pathinfo("/api/v1/question","POST"
				,new ArrayList<String>(Arrays.asList("ROLE_USER","ROLE_ADMIN"))));
		this.list.add(new Pathinfo("/api/v1/question/like/**","POST"
				,new ArrayList<String>(Arrays.asList("ROLE_USER","ROLE_ADMIN"))));
	}

	//등록된 url 인지 체크
	public boolean urlcheck(HttpServletRequest request,String auth) {
		
		String method = request.getMethod();
		String url = request.getRequestURI().toString().replaceAll("[0-9]{1,}$", "**");
		
		for(Pathinfo p : list) {
			//경로+method체크
			if(p.equals(new Pathinfo(url,method))) {
				//권한 체크
				if(p.getauth().contains(auth)) {
					return true;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	//로그인 체크(없으면 게스트)
	public String sessionCheck(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			request.setAttribute("auth", Role.ROLE_GUEST.value());
			request.setAttribute("name", "Guest");
			return "ROLE_GUEST";
		}else {
			String auth = session.getAttribute("auth").toString();
			request.setAttribute("auth", Role.valueOf(auth));
			request.setAttribute("name", session.getAttribute("name"));
			return auth;
		}
	}

}
