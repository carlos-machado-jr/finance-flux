package com.api.financeflux.application.outbound;

import java.util.Optional;

import com.api.financeflux.domain.TransactionDomain;

public interface TransactionRepository {

	TransactionDomain save(TransactionDomain transaction);
	Optional<TransactionDomain> findByIdTransaction();
}
