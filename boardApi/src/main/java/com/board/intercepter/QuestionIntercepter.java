package com.board.intercepter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.board.user.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Component
public class QuestionIntercepter implements HandlerInterceptor{

	private IntercepterCheck intercepterCheck = new IntercepterCheck();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler ) throws IOException {
	
		if(intercepterCheck.sessionNullCheck(request)) {
			HttpSession session = request.getSession(false);
			String auth = session.getAttribute("auth").toString();
			
			if(intercepterCheck.methodCheck("POST", request.getMethod())) {
				if(Role.ROLE_ADMIN.value().equals(auth)) {
					request.setAttribute("auth", Role.ROLE_ADMIN.value());
					request.setAttribute("name", session.getAttribute("name"));
					return true;
				}else if(Role.ROLE_USER.value().equals(auth)) {
					request.setAttribute("auth", Role.ROLE_USER.value());
					request.setAttribute("name", session.getAttribute("name"));
					return true;
				}else {
					System.out.println("1");
					response.sendRedirect("/api/v1/auth");
					return false;
				}
			}else {
				if(Role.ROLE_ADMIN.value().equals(auth)) {
					request.setAttribute("auth", Role.ROLE_ADMIN.value());
					request.setAttribute("name", session.getAttribute("name"));
					return true;
				}else if(Role.ROLE_USER.value().equals(auth)) {
					request.setAttribute("auth", Role.ROLE_USER.value());
					request.setAttribute("name", session.getAttribute("name"));
					return true;
				}else {
					request.setAttribute("auth", Role.ROLE_GUEST.value());
					request.setAttribute("name", "guest");
					return true;
				}
			}
		}else {
			System.out.println("2");
			response.sendRedirect("/api/v1/auth");
			return false;
		}
		
	}
}
