package com.api.financeflux.infra.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidationErrorTest {

	private ValidationError validationError;

	@BeforeEach
	void setUp() throws Exception {
		validationError = new ValidationError(400,"msg", 1000L);
	}

	@Test
	void testValidationError() {
		assertNotNull(validationError);
	}

	@Test
	void testGetAndSetErrors() {
		validationError.addError("error", "");
		assertNotNull(validationError.getErrors());
	}

	@Test
	void testAddError() {
		fail("Not yet implemented");
	}

}
