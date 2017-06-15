package com.rts.auth.modal;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {

	@Id
	private String id;
	private String username;
	private String password;
	private boolean active;
	private Set<Role> roles;

	public Account() {

	}

	public Account(String username, String password, boolean active, Set<Role> roles) {
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Account [ username=" + username + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + "]";
	}

}
