package com.api.financeflux.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class CurrencyDomain {

	private String idCurrency;
	private String symbol;
	private BigDecimal value;

	public CurrencyDomain() {
	}

	public CurrencyDomain(String symbol, BigDecimal value) {
		super();
		this.idCurrency = UUID.randomUUID().toString();
		this.symbol = symbol;
		this.value = value;
	}

	public String getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(String idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}



	
	

}
