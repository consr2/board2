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


public class Intercepter implements HandlerInterceptor{

	@Autowired
	private IntercepterCheck intercepterCheck;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler ) throws IOException {
	
		
		String auth = intercepterCheck.sessionCheck(request);
		
		if(intercepterCheck.urlcheck(request, auth)) {
			return true;
		}else {
			response.sendRedirect("/api/v1/auth");
			return false;
		}
		
	}
}
