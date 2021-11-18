package com.api.financeflux.infra.inbound;

import com.api.financeflux.domain.UserDomain;

public interface UserService {

	UserDomain save(UserDomain user);
	UserDomain findById(String id) throws Exception;
	
}
