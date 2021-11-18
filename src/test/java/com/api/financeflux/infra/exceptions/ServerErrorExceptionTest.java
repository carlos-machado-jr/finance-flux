package com.api.financeflux.infra.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServerErrorExceptionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testServerErrorExceptionString() {
		assertNotNull(new ServerErrorException("msg"));
	}

	@Test
	void testServerErrorExceptionStringThrowable() {
		assertNotNull(new ServerErrorException("msg", null));
	}

}
