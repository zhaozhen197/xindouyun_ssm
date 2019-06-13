package com.hello.model;

/**
 * ƾ֤
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class Token {
	private String accessToken;
	private int expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "Token{" +
				"accessToken='" + accessToken + '\'' +
				", expiresIn=" + expiresIn +
				'}';
	}
}