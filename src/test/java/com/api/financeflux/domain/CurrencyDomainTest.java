package com.api.financeflux.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrencyDomainTest {

	private CurrencyDomain currency;
	
	@BeforeEach
	void setUp() throws Exception {
	currency = new CurrencyDomain();
	currency.setIdCurrency("id");
	currency.setSymbol("symbol");
	currency.setValue(new BigDecimal(1));
	}

	@Test
	void testSetters() {
		currency = new CurrencyDomain("symbol", new BigDecimal(1));
		assertNotNull(currency.getIdCurrency());
		assertNotNull(currency.getSymbol());
		assertNotNull(currency.getValue());
	}

}
