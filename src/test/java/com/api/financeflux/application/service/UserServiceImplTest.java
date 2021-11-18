package com.api.financeflux.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.api.financeflux.application.outbound.UserRepository;
import com.api.financeflux.domain.UserDomain;

class UserServiceImplTest {

	private UserServiceImpl userService;
	private UserRepository userRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		userRepository = mock(UserRepository.class);
		userService = new UserServiceImpl(userRepository);
		when(userRepository.save(any())).thenReturn(new UserDomain());
		when(userRepository.findById(anyString())).thenReturn(new UserDomain());
	}

	@Test
	void testSave() {
		assertNotNull(userService.save(new UserDomain()));
	}

	@Test
	void testFindById() throws Exception {
		assertNotNull(userService.findById("id"));
	}

}
