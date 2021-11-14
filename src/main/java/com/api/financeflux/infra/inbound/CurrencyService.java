package com.api.financeflux.infra.inbound;

import com.api.financeflux.domain.CurrencyDomain;
import com.api.financeflux.domain.TransactionDomain;
import com.api.financeflux.domain.UserDomain;

public interface CurrencyService {

	TransactionDomain convertCurrency(CurrencyDomain origin, CurrencyDomain destination, UserDomain user) throws Exception;
}
