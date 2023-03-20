package com.board.user;

public enum Role {
	ROLE_GUEST("ROLE_GUEST"),
	ROLE_USER("ROLE_USER"),
	ROLE_ADMIN("ROLE_ADMIN");
	
	private String role;
	
	Role(String role) {
		this.role = role;
	}
	
	public String value() {
		return role;
	}
}
