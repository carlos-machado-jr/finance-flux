package com.api.financeflux.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CurrencyRateTest {


	 CurrencyRate rate;
	
	@BeforeEach
	public void setUp() throws Exception {
		rate = new CurrencyRate();
		rate.setOriginValue(new BigDecimal(6.302769));
		rate.setDestinationValue(new BigDecimal(1.147756));
	}

	@Test
	public void testSetters() {
		rate = new CurrencyRate(new BigDecimal(2), new BigDecimal(2));
		assertNotNull(rate.getDestinationValue());
		assertNotNull(rate.getOriginValue());
	}
	
	

}
