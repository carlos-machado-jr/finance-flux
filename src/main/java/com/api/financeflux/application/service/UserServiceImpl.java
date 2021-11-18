package com.api.financeflux.application.service;

import com.api.financeflux.application.outbound.UserRepository;
import com.api.financeflux.domain.UserDomain;
import com.api.financeflux.infra.inbound.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public UserDomain save(UserDomain user) {
		return userRepository.save(user);
	}
	@Override
	public UserDomain findById(String id) throws Exception {
		return userRepository.findById(id);
	}
	

}
