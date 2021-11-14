package com.api.financeflux.infra.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.financeflux.application.outbound.TransactionRepository;
import com.api.financeflux.domain.TransactionDomain;
@Component
public class TransactionRepositoryImpl implements TransactionRepository {

	@Override
	public TransactionDomain save(TransactionDomain transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TransactionDomain> findByIdTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

}
