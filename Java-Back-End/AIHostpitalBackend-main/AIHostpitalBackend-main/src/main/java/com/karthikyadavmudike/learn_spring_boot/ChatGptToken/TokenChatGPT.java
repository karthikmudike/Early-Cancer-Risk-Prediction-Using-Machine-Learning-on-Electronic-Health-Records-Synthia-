package com.karthikyadavmudike.learn_spring_boot.ChatGptToken;

public class TokenChatGPT {
	
	private String TokenAPI;

	public String getToken() {
		return TokenAPI;
	}

	public void setToken(String token) {
		this.TokenAPI = token;
	}

	@Override
	public String toString() {
		return "Token [token=" + TokenAPI + "]";
	}
	
	

}
