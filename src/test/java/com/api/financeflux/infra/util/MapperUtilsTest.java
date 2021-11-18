package com.api.financeflux.infra.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.api.financeflux.domain.UserDomain;
import com.api.financeflux.infra.entity.UserEntity;

class MapperUtilsTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMapTClassOfD() {
		assertNotNull(MapperUtils.map(new UserDomain("carlos", "ssss"), UserEntity.class));
	}

	@Test
	void testMapAll() {
		List<UserDomain> users = List.of(new UserDomain("carlos", "ssss"));
		assertNotNull(MapperUtils.map(users, UserEntity.class));
	}

	@Test
	void testMapSD() {
		assertNotNull(MapperUtils.map(new UserDomain("carlos", "ssss"), new UserEntity()));
	}

}
