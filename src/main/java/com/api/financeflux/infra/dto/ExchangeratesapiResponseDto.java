package com.api.financeflux.infra.dto;

import java.math.BigDecimal;
import java.util.Map;

public class ExchangeratesapiResponseDto {
	private Map<String, BigDecimal> rates;

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "ExchangeratesapiResponseDto [rates=" + rates + "]";
	}

	
}
