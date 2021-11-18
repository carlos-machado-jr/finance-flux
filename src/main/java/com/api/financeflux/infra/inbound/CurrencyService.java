package com.api.financeflux.infra.inbound;

import com.api.financeflux.domain.CurrencyDomain;
import com.api.financeflux.domain.UserDomain;

public interface CurrencyService {

	UserDomain convertCurrency(CurrencyDomain origin, CurrencyDomain destination, String idUser) throws Exception;
}
