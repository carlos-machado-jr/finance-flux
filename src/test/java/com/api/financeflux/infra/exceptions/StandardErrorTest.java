package com.api.financeflux.infra.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardErrorTest {

	private StandardError error;

	@BeforeEach
	void setUp() throws Exception {
		error = new StandardError(400, "", 1000L);
	}

	@Test
	void testStandardErrorConstructor() {
		assertNotNull(new StandardError(100, "", "", 100L));
	}

	@Test
	void testGetStatus() {
		error.setStatus(100);
		assertNotNull(error.getStatus());
	}

	@Test
	void testGetMessage() {
		error.setMessage("");
		assertNotNull(error.getMessage());
	}

	@Test
	void testGetDetailMessage() {
		error.setDetailMessage("");
		assertNotNull(error.getDetailMessage());
	}

	@Test
	void testGetTimeStamp() {
		error.setTimeStamp(100L);
		assertNotNull(error.getTimeStamp());
	}

}
