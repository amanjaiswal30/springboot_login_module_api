package com.server.model;
import java.io.Serializable;
/**
 * Handles the incoming request from the client. 
 */
public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String username;
	private String password;
	/**
	 * @param username crentials entered in the form
	 * @param password credentials entered in the form
	 */
	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}