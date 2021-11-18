package com.api.financeflux.application.service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.api.financeflux.application.outbound.CurrencyRestGateway;
import com.api.financeflux.domain.CurrencyDomain;
import com.api.financeflux.domain.CurrencyRate;
import com.api.financeflux.domain.TransactionDomain;
import com.api.financeflux.domain.UserDomain;
import com.api.financeflux.infra.exceptions.ServerErrorException;
import com.api.financeflux.infra.inbound.CurrencyService;
import com.api.financeflux.infra.inbound.UserService;

public class CurrencyServiceImpl implements CurrencyService {

	private static final String CAMPOS_NULOS = "Campos nulos!";
	private final CurrencyRestGateway gateway;
	private final UserService userService;

	public CurrencyServiceImpl(CurrencyRestGateway gateway, UserService userService) {
		this.gateway = gateway;
		this.userService = userService;
	}

	@Override
	public UserDomain convertCurrency(CurrencyDomain origin, CurrencyDomain destination, String idUser)
			throws Exception {
		if (isNull(origin, CurrencyDomain.class) || isNull(destination.getSymbol()))
			throw new ServerErrorException(CAMPOS_NULOS);
		UserDomain user = userService.findById(idUser);
		List<TransactionDomain> transactions = new ArrayList<>();
		transactions.add(convertCurrency(origin, destination));
		user.setTransactions(transactions);
		return userService.save(user);
	}

	private TransactionDomain convertCurrency(CurrencyDomain origin, CurrencyDomain destination) throws Exception {
		final CurrencyRate currencyRate = gateway.requestCurrencyBySymbols(origin.getSymbol(), destination.getSymbol());
		final BigDecimal conversionRate = getConversionRate(currencyRate);
		destination.setValue(getDestinationValue(conversionRate, origin.getValue()));
		return new TransactionDomain(origin, destination, conversionRate);
	}

	private BigDecimal getDestinationValue(BigDecimal conversionRate, BigDecimal value) {
		return conversionRate.multiply(value);
	}

	private BigDecimal getConversionRate(CurrencyRate currencyRate)
			throws IllegalArgumentException, IllegalAccessException {
		if (isNull(currencyRate, CurrencyRate.class))
			throw new ServerErrorException(CAMPOS_NULOS);
		final BigDecimal destinationValue = currencyRate.getDestinationValue();
		return currencyRate.getOriginValue().divide(destinationValue, 20, RoundingMode.HALF_UP);
	}

	private <T> boolean isNull(T object, Class<T> classOfT) throws IllegalArgumentException, IllegalAccessException {
		
		if(isNull(object))
			return true;
		
		Field[] fields = classOfT.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field);
			Object fieldObject = field.get(object);
			if (isNull(fieldObject))
				return true;
		}
		return false;
	}

	private boolean isNull(Object object) {
		if (Objects.isNull(object))
			return true;
		return false;
	}

}
