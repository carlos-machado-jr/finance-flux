package com.api.financeflux.application.outbound;

import java.util.List;

import com.api.financeflux.domain.UserDomain;

public interface UserRepository {

	UserDomain save(UserDomain user);
	UserDomain findById(String id) throws Exception;
	List<UserDomain> findAll();
	
}
