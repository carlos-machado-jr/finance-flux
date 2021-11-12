package com.api.financeflux.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDomainTest {

	private UserDomain user;
	
	@BeforeEach
	void setUp() throws Exception {
		user = new UserDomain();
		user.setIdUser("id");
		user.setName("name");
		user.setPassword("pass");
	}

	@Test
	void testSetters() {
		user = new UserDomain("sss", "name", "pass");
		assertNotNull(user.getIdUser());
		assertNotNull(user.getName());
		assertNotNull(user.getPassword());
	}

}
