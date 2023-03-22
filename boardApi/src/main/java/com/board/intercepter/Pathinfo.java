package com.board.intercepter;

import java.util.List;
import java.util.Objects;

public class Pathinfo {

	private String startURL;
	private String method;
	private List<String> auth;
	
	public Pathinfo (String url, String method) {
		this.startURL = url;
		this.method = method;
	}
	
	public Pathinfo (String url, String method, List<String> auth) {
		this.startURL = url;
		this.method = method;
		this.auth = auth;
	}
	
	public List<String> getauth(){
		return this.auth;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pathinfo other = (Pathinfo) obj;
		return Objects.equals(method, other.method) && Objects.equals(startURL, other.startURL);
	}


	@Override
	public String toString() {
		return "Pathinfo [startURL=" + startURL + ", method=" + method + ", auth=" + auth + "]";
	}



	
}
