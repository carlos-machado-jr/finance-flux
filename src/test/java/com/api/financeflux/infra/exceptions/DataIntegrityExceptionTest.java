package com.api.financeflux.infra.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataIntegrityExceptionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testDataIntegrityExceptionString() {
		assertNotNull(new DataIntegrityException("msg"));
	}

	@Test
	void testDataIntegrityExceptionStringThrowable() {
		assertNotNull(new DataIntegrityException("msg", null));
	}

}
