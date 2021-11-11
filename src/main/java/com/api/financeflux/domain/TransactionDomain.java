package com.api.financeflux.domain;

import java.time.LocalDateTime;

public class TransactionDomain {
	private String idTransaction;
	private UserDomain user;
	private CurrencyDomain currencyOrigin;
	private CurrencyDomain currencyDestination;
	private String conversionRate;
	private LocalDateTime dateTime;

	public TransactionDomain() {
	}

	public TransactionDomain(String idTransaction, UserDomain user, CurrencyDomain currencyOrigin,
			CurrencyDomain currencyDestination, String conversionRate, LocalDateTime dateTime) {
		super();
		this.idTransaction = idTransaction;
		this.user = user;
		this.currencyOrigin = currencyOrigin;
		this.currencyDestination = currencyDestination;
		this.conversionRate = conversionRate;
		this.dateTime = dateTime;
	}

	public String getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}

	public UserDomain getUser() {
		return user;
	}

	public void setUser(UserDomain user) {
		this.user = user;
	}

	public CurrencyDomain getCurrencyOrigin() {
		return currencyOrigin;
	}

	public void setCurrencyOrigin(CurrencyDomain currencyOrigin) {
		this.currencyOrigin = currencyOrigin;
	}

	public CurrencyDomain getCurrencyDestination() {
		return currencyDestination;
	}

	public void setCurrencyDestination(CurrencyDomain currencyDestination) {
		this.currencyDestination = currencyDestination;
	}

	public String getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
