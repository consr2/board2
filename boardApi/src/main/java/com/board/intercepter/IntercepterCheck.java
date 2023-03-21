package com.board.intercepter;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.stereotype.Component;

import com.board.user.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class IntercepterCheck {

	public boolean sessionNullCheck(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public boolean methodCheck(String method1, String method2) {
		if(method1.equals(method2)) {
			return true;
		}else {
			return false;
		}
	}
}
