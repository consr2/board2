package com.board.intercepter;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.board.user.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CreateIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler ) throws IOException {
		
		HttpSession session = request.getSession(false);
		String auth = null;
		if(session == null) {
			auth = "null";
		}else {
			auth = (String)session.getAttribute("auth");
			System.out.println("session : " + session.getAttribute("name").toString());
			System.out.println("session : " + session.getAttribute("auth").toString());
		}
		
		String method = request.getMethod();
		System.out.println("메소드 : " + method);
		
		if(method.equals(HttpMethod.POST.toString())) {
			if(Role.ROLE_ADMIN.value().equals(auth)) {
				return true;
			}else if(Role.ROLE_USER.value().equals(auth)) {
				return true;
			}else {
				response.sendRedirect("/api/v1/auth");
				return false;
			}
		}else {
			return true;
		}
		
		
	}


}
