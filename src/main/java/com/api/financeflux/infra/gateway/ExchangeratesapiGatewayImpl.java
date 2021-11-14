package com.api.financeflux.infra.gateway;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.financeflux.application.outbound.CurrencyRestGateway;
import com.api.financeflux.domain.CurrencyRate;
import com.api.financeflux.infra.dto.ExchangeratesapiResponseDto;

@Component
public class ExchangeratesapiGatewayImpl implements CurrencyRestGateway {

	private static final String BASE_URL = "http://api.exchangeratesapi.io/v1/";
	private static final String LATEST = "latest";
	private static final String ACCESS_KEY = "5a6c82568ba05c3d06010c01089b57b1";


	@Autowired
	private WebClient client;

	@Override
	public CurrencyRate requestCurrencyBySymbols(@NonNull String origin, @NonNull String destination) throws Exception {
		if(validateText(origin, destination))
			throw new Exception("null");
		var params = new StringBuilder(origin).append(",").append(destination).toString();
		var url = UriComponentsBuilder
				.fromHttpUrl(BASE_URL)
				.path(LATEST)
				.queryParam("access_key", ACCESS_KEY)
				.queryParam("symbols", params)
				.build()
				.toString();

		var mono = this.client
				.method(HttpMethod.GET)
				.uri(url)
				.retrieve()
				.bodyToMono(ExchangeratesapiResponseDto.class);
		var responseBody = mono.block();
		var originValue = responseBody.getRates().get(origin);
		var destinationValue = responseBody.getRates().get(destination);
		return new CurrencyRate(originValue,destinationValue);
			

	}


	private boolean validateText(String origin, String destination) {
		return (Objects.isNull(origin) || Objects.isNull(destination));
	}

}
