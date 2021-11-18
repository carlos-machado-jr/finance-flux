package com.api.financeflux.infra.repository.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.financeflux.domain.CurrencyDomain;
import com.api.financeflux.domain.TransactionDomain;
import com.api.financeflux.domain.UserDomain;
import com.api.financeflux.infra.entity.UserEntity;
import com.api.financeflux.infra.exceptions.ObjectNotFoundException;
import com.api.financeflux.infra.repository.UserRepositoryJpa;
import com.api.financeflux.infra.util.MapperUtils;

@SpringBootTest
class UserRepositoryImplTest {

	@InjectMocks
	private UserRepositoryImpl userRepository;

	@Mock
	private UserRepositoryJpa mongoRepository;
	private UserDomain user;
	private List<TransactionDomain> transactions;
	private CurrencyDomain dest;
	private CurrencyDomain origin;

	private UserEntity userEntity;

	private List<UserEntity> usersEntity;

	@BeforeEach
	void setUp() throws Exception {
		mountUserDomain();
		userEntity = MapperUtils.map(user, UserEntity.class);
		usersEntity = new ArrayList<>();
		usersEntity.add(userEntity);
		when(mongoRepository.save(any())).thenReturn(userEntity);
		when(mongoRepository.findById("a4ac126a-7b8c-4cbc-88a8-dee9a17d986a")).thenReturn(Optional.of(userEntity));
		when(mongoRepository.findAll()).thenReturn(usersEntity);

	}

	private void mountUserDomain() {
		dest = new CurrencyDomain("BRL", BigDecimal.valueOf(10));
		origin = new CurrencyDomain("USD", BigDecimal.valueOf(1.5));
		transactions = new ArrayList<>();
		transactions.add(new TransactionDomain(origin, dest, BigDecimal.TEN));
		transactions.add(new TransactionDomain(origin, dest, BigDecimal.TEN));
		user = new UserDomain("Carlos", "admsmdpos", transactions);

	}

	@Test
	void testSave() {
		assertNotNull(userRepository.save(user));
	}

	@Test
	void testFindById() throws Exception {
		assertNotNull(userRepository.findById("a4ac126a-7b8c-4cbc-88a8-dee9a17d986a"));
	}

	@Test
	void testFindByIdExceptionNull() throws Exception {
		when(mongoRepository.findAll()).thenReturn(null);
		assertThrows(ObjectNotFoundException.class,
				() -> userRepository.findById("0000000-7b8c-4cbc-88a8-dee9a17d986a"));
	}

	@Test
	void testFindAll() {
		assertNotNull(userRepository.findAll());
	}

}
