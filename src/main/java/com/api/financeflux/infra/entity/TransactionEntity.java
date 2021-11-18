package com.api.financeflux.infra.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction")
public class TransactionEntity {

	@Id
	private String idTransaction;
	private CurrencyEntity currencyOrigin;
	private CurrencyEntity currencyDestination;
	private BigDecimal conversionRate;
	private LocalDateTime dateTime;

	public String getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}

	public CurrencyEntity getCurrencyOrigin() {
		return currencyOrigin;
	}

	public void setCurrencyOrigin(CurrencyEntity currencyOrigin) {
		this.currencyOrigin = currencyOrigin;
	}

	public CurrencyEntity getCurrencyDestination() {
		return currencyDestination;
	}

	public void setCurrencyDestination(CurrencyEntity currencyDestination) {
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
