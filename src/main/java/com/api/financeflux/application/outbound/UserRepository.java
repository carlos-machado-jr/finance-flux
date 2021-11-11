package com.api.financeflux.application.outbound;

import com.api.financeflux.domain.UserDomain;

public interface UserRepository {

	UserDomain save(UserDomain user);
	
}
