package com.api.financeflux.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionDomainTest {

	private TransactionDomain transaction;
	
	@BeforeEach
	void setUp() throws Exception {
	transaction = new TransactionDomain();
	transaction.setCurrencyOrigin(new CurrencyDomain("id", "symbol", new BigDecimal(1.0)));
	transaction.setCurrencyDestination(new CurrencyDomain("id", "symbol", new BigDecimal(1.0)));
	transaction.setIdTransaction("id");
	transaction.setConversionRate(new BigDecimal(1.0));
	transaction.setDateTime(LocalDateTime.now());
	transaction.setUser(new UserDomain());
	}

	@Test
	void testSetters() {
		transaction = new TransactionDomain(new UserDomain(), new CurrencyDomain(), new CurrencyDomain(), new BigDecimal(1.0));
		assertNotNull(transaction.getIdTransaction());
		assertNotNull(transaction.getCurrencyOrigin());
		assertNotNull(transaction.getCurrencyDestination());
		assertNotNull(transaction.getConversionRate());
		assertNotNull(transaction.getDateTime());
		assertNotNull(transaction.getUser());
	
	}

}
