package com.server.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
/**
 * This maps the table in the database where data is to be stored and retrieved from.
 */
@Entity
@Table(name = "user")
public class UserDataAccessObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
