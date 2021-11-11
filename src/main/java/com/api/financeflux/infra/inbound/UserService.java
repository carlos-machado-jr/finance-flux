package com.api.financeflux.infra.inbound;

import com.api.financeflux.domain.UserDomain;

public interface UserService {

	UserDomain register(UserDomain user);
	
}
