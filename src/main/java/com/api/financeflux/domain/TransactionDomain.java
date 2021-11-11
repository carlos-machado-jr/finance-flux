package com.api.financeflux.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionDomain {
	private String idTransaction;
	private UserDomain user;
	private CurrencyDomain currencyOrigin;
	private CurrencyDomain currencyDestination;
	private BigDecimal conversionRate;
	private LocalDateTime dateTime;

	public TransactionDomain() {
	}

	public TransactionDomain(UserDomain user, CurrencyDomain currencyOrigin,
			CurrencyDomain currencyDestination, BigDecimal conversionRate) {
		super();
		this.idTransaction = UUID.randomUUID().toString();
		this.user = user;
		this.currencyOrigin = currencyOrigin;
		this.currencyDestination = currencyDestination;
		this.conversionRate = conversionRate;
		this.dateTime = LocalDateTime.now();
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

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
