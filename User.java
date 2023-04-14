# User.java
package com.framgia.androidsqlite;

public class User {
	int id;
	String name;
	String password;
	String login_name ;

	public User(int id, String name, String password, String login_name) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.login_name = login_name;
	}

	public Student(String name, String password, String login_name) {
		super();
		this.name = name;
		this.password = password;
		this.login_name = login_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
}
