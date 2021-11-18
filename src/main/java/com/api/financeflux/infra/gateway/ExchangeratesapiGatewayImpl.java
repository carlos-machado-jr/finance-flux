package com.api.financeflux.infra.gateway;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.AccessDeniedException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.financeflux.application.outbound.CurrencyRestGateway;
import com.api.financeflux.domain.CurrencyRate;
import com.api.financeflux.infra.dto.ExchangeratesapiResponseDto;
import com.api.financeflux.infra.exceptions.AuthorizationException;
import com.api.financeflux.infra.exceptions.ObjectNotFoundException;
import com.api.financeflux.infra.exceptions.ServerErrorException;
import com.google.gson.Gson;

@Component
public class ExchangeratesapiGatewayImpl implements CurrencyRestGateway {

	private static final String BASE_URL = "http://api.exchangeratesapi.io/v1/";
	private static final String LATEST = "latest";
	private static final String ACCESS_KEY = "5a6c82568ba05c3d06010c01089b57b1";


	
	@Autowired
	private HttpClient client;

	@Override
	public CurrencyRate requestCurrencyBySymbols(@NonNull String origin, @NonNull String destination) throws Exception {
		
		if(!hasText(origin) || !hasText(destination))
			throw new DataIntegrityViolationException("Campos nulos!");
		
		var params = new StringBuilder(origin).append(",").append(destination).toString();
		var url = UriComponentsBuilder
				.fromHttpUrl(BASE_URL)
				.path(LATEST)
				.queryParam("access_key", ACCESS_KEY)
				.queryParam("symbols", params)
				.build()
				.toUri();
		HttpRequest request = HttpRequest
				.newBuilder(url)
				.GET()
				.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		verifyResponse(response);
		ExchangeratesapiResponseDto dto = new Gson().fromJson(response.body(), ExchangeratesapiResponseDto.class);
		
		var originValue = dto.getRates().get(origin.toUpperCase());
		var destinationValue = dto.getRates().get(destination.toUpperCase());
		if(isNull(originValue) || isNull(destinationValue))
			throw new DataIntegrityViolationException("Requisição incorreta! campos faltando no response: " + dto);
		
		return new CurrencyRate(originValue,destinationValue);
			

	}

	private void verifyResponse(HttpResponse<String> response) throws Exception {
		if(response.statusCode() == 200)
			return;
		final String bodyResponse = new JSONObject(response.body()).getJSONObject("error").getString("message");
		final String message = new StringBuilder("Erro ao tentar realizar chamada ao serviço REST Exchangerates. Retorno da requisição: ")
				.append(bodyResponse).toString();
		switch (response.statusCode()) {
		case 400: 
			throw new DataIntegrityViolationException(message);
		case 401: 
			throw new AuthorizationException(message, null);
		case 403: 
			throw new AccessDeniedException(message);
		case 404: 
			throw new ObjectNotFoundException(message);
		default:
			throw new ServerErrorException(message);
		}
		
			
		
			
		
	}


}
