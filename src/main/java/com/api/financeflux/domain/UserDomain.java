package com.api.financeflux.domain;

import java.util.List;
import java.util.UUID;

public class UserDomain {

	private String idUser;
	private String name;
	private String password;
	private List<TransactionDomain> transactions;

	public UserDomain() {
	}

	public UserDomain(String name, String password) {
		super();
		this.idUser = UUID.randomUUID().toString();
		this.name = name;
		this.password = password;
	}

	
	public UserDomain( String name, String password, List<TransactionDomain> transactions) {
		super();
		this.idUser = UUID.randomUUID().toString();
		this.name = name;
		this.password = password;
		this.transactions = transactions;
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

	public List<TransactionDomain> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDomain> transactions) {
		this.transactions = transactions;
	}


	
}
