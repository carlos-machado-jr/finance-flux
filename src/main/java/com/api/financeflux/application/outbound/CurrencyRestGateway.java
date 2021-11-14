package com.api.financeflux.application.outbound;

import com.api.financeflux.domain.CurrencyRate;

public interface CurrencyRestGateway {

	CurrencyRate requestCurrencyBySymbols(String origin, String destination) throws Exception;
}
