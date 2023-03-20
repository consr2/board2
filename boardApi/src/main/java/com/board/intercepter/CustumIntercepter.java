package com.board.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import com.board.user.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustumIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler ) {
		
		log.info("request : " + request.getParameter("Authentication"));
		String auth = request.getParameter("Authentication");
		String a = Role.valueOf(auth);
		
		if(Role != null) {
			return true;
		}
		
		
		return false;
	}


}
