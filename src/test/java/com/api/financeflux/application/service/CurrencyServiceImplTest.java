package com.api.financeflux.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.api.financeflux.application.outbound.CurrencyRestGateway;
import com.api.financeflux.application.outbound.TransactionRepository;
import com.api.financeflux.domain.CurrencyDomain;
import com.api.financeflux.domain.CurrencyRate;
import com.api.financeflux.domain.TransactionDomain;
import com.api.financeflux.domain.UserDomain;

class CurrencyServiceImplTest {
	private CurrencyServiceImpl currency;
	private CurrencyRestGateway gateway;
	private TransactionRepository repository;
	private UserDomain user;
	private TransactionDomain transaction;
	private CurrencyDomain currencyOrigin;
	private CurrencyDomain currencyDestination;

	@BeforeEach
	void setUp() throws Exception {
		gateway = mock(CurrencyRestGateway.class);
		repository = mock(TransactionRepository.class);
		currency = new CurrencyServiceImpl(gateway, repository);
		mockGateway();
		mockRepository();
	}

	private void mockRepository() {
		currencyOrigin = new CurrencyDomain("id", "BRL", new BigDecimal("10"));
		currencyDestination = new CurrencyDomain("id", "USD", new BigDecimal("54.91384057238647"));
		user = new UserDomain("id", "name", "pass");
		transaction = new TransactionDomain(user, currencyOrigin, currencyDestination,
				new BigDecimal("5.491384057238647"));
		when(repository.save(any())).thenReturn(transaction);

	}

	private void mockGateway() throws Exception {
		BigDecimal originValue = new BigDecimal("6.302769");
		BigDecimal destinationValue = new BigDecimal("1.147756");
		when(gateway.requestCurrencyBySymbols(anyString(), anyString()))
				.thenReturn(new CurrencyRate(originValue, destinationValue));

	}

	@Test
	void convertCurrencyTest() throws Exception {
		assertEquals(transaction, currency.convertCurrency(currencyOrigin, currencyDestination, user));
	}

}
