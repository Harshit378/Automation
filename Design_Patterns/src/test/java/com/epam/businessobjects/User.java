package com.epam.businessobjects;

public class User implements Comparable<User> {
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public int compareTo(User o) {
		return this.userName.compareTo(o.userName);
	}

}
