package com.api.financeflux.infra.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ObjectNotFoundExceptionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testObjectNotFoundExceptionString() {
		assertNotNull(new ObjectNotFoundException("msg"));
	}

	@Test
	void testObjectNotFoundExceptionStringThrowable() {
		assertNotNull(new ObjectNotFoundException("msg", null));
	}

}
