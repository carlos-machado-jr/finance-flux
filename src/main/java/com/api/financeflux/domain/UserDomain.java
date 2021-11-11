package com.api.financeflux.domain;

public class UserDomain {

	private String idUser;
	private String name;
	private String password;

	public UserDomain() {
	}

	public UserDomain(String idUser, String name, String password) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.password = password;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
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

}
