package com.api.financeflux.infra.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorizationExceptionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAuthorizationExceptionString() {
		assertNotNull(new AuthorizationException("msg"));
	}

	@Test
	void testAuthorizationExceptionStringThrowable() {
		assertNotNull(new AuthorizationException("msg", null));
	}

}
