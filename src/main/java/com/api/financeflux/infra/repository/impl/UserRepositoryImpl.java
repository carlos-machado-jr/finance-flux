package com.api.financeflux.infra.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.financeflux.application.outbound.UserRepository;
import com.api.financeflux.domain.UserDomain;
import com.api.financeflux.infra.entity.UserEntity;
import com.api.financeflux.infra.exceptions.ObjectNotFoundException;
import com.api.financeflux.infra.repository.UserRepositoryJpa;
import com.api.financeflux.infra.util.MapperUtils;

@Component
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private UserRepositoryJpa mongoRepository;

	@Override
	public UserDomain save(UserDomain user) {
		UserEntity userEntity = MapperUtils.map(user, UserEntity.class);
		userEntity = mongoRepository.save(userEntity);
		return MapperUtils.map(userEntity, UserDomain.class);
	}

	@Override
	public UserDomain findById(String id) throws Exception {
		UserEntity userEntity = mongoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("id informado não foi encontrado! id: ".concat(id)));
		return MapperUtils.map(userEntity, UserDomain.class);
	}

	@Override
	public List<UserDomain> findAll() {
		List<UserEntity> user = mongoRepository.findAll();
		return MapperUtils.mapAll(user, UserDomain.class);
	}

}
