package com.api.financeflux.domain;

import java.math.BigDecimal;

public class CurrencyRate {

	private BigDecimal originValue;
	private BigDecimal destinationValue;
	
	public CurrencyRate() {
	}

	public CurrencyRate(BigDecimal originValue, BigDecimal destinationValue) {
		super();
		this.originValue = originValue;
		this.destinationValue = destinationValue;
	}

	public BigDecimal getOriginValue() {
		return originValue;
	}

	public void setOriginValue(BigDecimal originValue) {
		this.originValue = originValue;
	}

	public BigDecimal getDestinationValue() {
		return destinationValue;
	}

	public void setDestinationValue(BigDecimal destinationValue) {
		this.destinationValue = destinationValue;
	}

	
}
