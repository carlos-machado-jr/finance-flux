package com.api.financeflux.infra.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FieldMessageTest {
	
	private FieldMessage field;

	@BeforeEach
	void setUp() throws Exception {
		field = new FieldMessage();
	}

	@Test
	void testFieldMessageStringString() {
		assertNotNull(new FieldMessage("", ""));
	}

	@Test
	void testGetFieldName() {
		field.setFieldName("");
		assertNotNull(field.getFieldName());
	}

	@Test
	void testGetMessage() {
		field.setMessage("");
		assertNotNull(field.getMessage());
	}

}
