package com.api.financeflux.infra.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collation = "currency")
public class CurrencyEntity {

	private String idCurrency;
	private String symbol;
	private BigDecimal value;


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
