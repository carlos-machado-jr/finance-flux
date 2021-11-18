package com.api.financeflux.application.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.api.financeflux.application.outbound.CurrencyRestGateway;
import com.api.financeflux.domain.CurrencyDomain;
import com.api.financeflux.domain.CurrencyRate;
import com.api.financeflux.domain.UserDomain;
import com.api.financeflux.infra.exceptions.ServerErrorException;
import com.api.financeflux.infra.inbound.UserService;

class CurrencyServiceImplTest {
	private CurrencyServiceImpl currency;
	private CurrencyRestGateway gateway;
	private UserService userService;
	private UserDomain user;
	
	private CurrencyDomain currencyOrigin;
	private CurrencyDomain currencyDestination;
	private BigDecimal originValue;
	private BigDecimal destinationValue;

	@BeforeEach
	void setUp() throws Exception {
		gateway = mock(CurrencyRestGateway.class);
		userService = mock(UserService.class);
		currency = new CurrencyServiceImpl(gateway, userService);
		mockGateway();
		mockRepository();
	}
	
	@Test
	void convertCurrencyTest() throws Exception {
		assertNotNull(currency.convertCurrency(currencyOrigin, currencyDestination, user.getIdUser()));
	}
	
	@Test
	void convertCurrencyTestCurrencyRateNull() throws Exception {
		when(gateway.requestCurrencyBySymbols(anyString(), anyString()))
		.thenReturn(null);
		assertThrows(ServerErrorException.class, () -> currency.convertCurrency(currencyOrigin, currencyDestination, user.getIdUser()));
	}
	@Test
	void convertCurrencyTestCurrencyOriginNull() throws Exception {
		assertThrows(ServerErrorException.class, () -> currency.convertCurrency(null, currencyDestination, user.getIdUser()));
	}
	
	@Test
	void convertCurrencyTestCurrencyDestinationSymbolNull() throws Exception {
		currencyDestination = new CurrencyDomain(null, null);
		assertThrows(ServerErrorException.class, () -> currency.convertCurrency(currencyOrigin, currencyDestination, user.getIdUser()));
	}
	
	
	@Test
	void convertCurrencyTestCurrencyRateDestinationValueNull() throws Exception {
		when(gateway.requestCurrencyBySymbols(anyString(), anyString()))
		.thenReturn(new CurrencyRate(originValue, null));
		assertThrows(ServerErrorException.class, () -> currency.convertCurrency(currencyOrigin, currencyDestination, user.getIdUser()));
	}
	
	private void mockRepository() throws Exception {
		currencyOrigin = new CurrencyDomain("BRL", new BigDecimal("10"));
		currencyDestination = new CurrencyDomain( "USD", new BigDecimal("54.91384057238647"));
		user = new UserDomain("name", "pass");
		when(userService.findById(anyString())).thenReturn(user);
		when(userService.save(any())).thenReturn(user);

	}

	private void mockGateway() throws Exception {
		originValue = new BigDecimal("6.302769");
		destinationValue = new BigDecimal("1.147756");
		when(gateway.requestCurrencyBySymbols(anyString(), anyString()))
				.thenReturn(new CurrencyRate(originValue, destinationValue));

	}

}
