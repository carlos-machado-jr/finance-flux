package com.api.financeflux.application.outbound;

public interface CurrencyRestGateway {

	String requestCurrencyBySymbols(String... symbols);
	String requestAllCurrency();
}
