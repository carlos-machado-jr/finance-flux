package com.api.financeflux.application.service;

import java.math.BigDecimal;

import com.api.financeflux.application.outbound.CurrencyRestGateway;
import com.api.financeflux.application.outbound.TransactionRepository;
import com.api.financeflux.domain.CurrencyDomain;
import com.api.financeflux.domain.CurrencyRate;
import com.api.financeflux.domain.TransactionDomain;
import com.api.financeflux.domain.UserDomain;
import com.api.financeflux.infra.inbound.CurrencyService;

public class CurrencyServiceImpl implements CurrencyService {

	private final CurrencyRestGateway gateway;
	private final TransactionRepository repository;

	public CurrencyServiceImpl(CurrencyRestGateway gateway, TransactionRepository repository) {
		this.gateway = gateway;
		this.repository = repository;
	}

	@Override
	public TransactionDomain convertCurrency(CurrencyDomain origin, CurrencyDomain destination, UserDomain user) {
		final CurrencyRate currencyRate = gateway.requestCurrencyBySymbols(origin.getSymbol(), destination.getSymbol());
		final BigDecimal conversionRate = getConversionRate(currencyRate);
		destination.setValue(getDestinationValue(conversionRate, origin.getValue()));
		TransactionDomain transaction = new TransactionDomain(user, origin, destination, conversionRate);
		return repository.save(transaction);
	}

	private BigDecimal getDestinationValue(BigDecimal conversionRate, BigDecimal value) {
		return conversionRate.multiply(value);
	}

	private BigDecimal getConversionRate(CurrencyRate currencyRate) {
		final BigDecimal destinationValue = currencyRate.getDestinationValue();
		return currencyRate.getOriginValue().divide(destinationValue);
	}

}
