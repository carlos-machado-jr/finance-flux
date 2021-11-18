package com.api.financeflux.infra.gateway;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.file.AccessDeniedException;
import java.util.Map;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import com.api.financeflux.infra.dto.ExchangeratesapiResponseDto;
import com.api.financeflux.infra.exceptions.AuthorizationException;
import com.api.financeflux.infra.exceptions.ObjectNotFoundException;
import com.api.financeflux.infra.exceptions.ServerErrorException;
import com.google.gson.Gson;

@SpringBootTest
class ExchangeratesapiGatewayImplTest {

	@InjectMocks
	private ExchangeratesapiGatewayImpl exchange;

	@Mock
	private HttpClient client;

	private ExchangeratesapiResponseDto dto;

	private HttpResponse<Object> response;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		dto = new ExchangeratesapiResponseDto();
		dto.setRates(Map.of("BRL", BigDecimal.valueOf(6), "USD", BigDecimal.valueOf(1)));
		response = mock(HttpResponse.class);
		when(client.send(any(), any())).thenReturn(response);
		when(response.statusCode()).thenReturn(200);
		when(response.body()).thenReturn(getResponse());

	}

	@Test
	void testRequestCurrencyBySymbols() throws Exception {
		exchange.requestCurrencyBySymbols("BRL", "USD");
	}

	@Test
	void testRequestCurrencyBySymbolsWithValuesNull() throws Exception {
		assertThrows(DataIntegrityViolationException.class, () -> exchange.requestCurrencyBySymbols(null, null));
	}

	@Test
	void testRequestCurrencyBySymbolsWithOriginNull() throws Exception {
		assertThrows(DataIntegrityViolationException.class, () -> exchange.requestCurrencyBySymbols(null, "USD"));
	}

	@Test
	void testRequestCurrencyBySymbolsWithDestinationNull() throws Exception {
		assertThrows(DataIntegrityViolationException.class, () -> exchange.requestCurrencyBySymbols("BRL", null));
	}

	@Test
	void testRequestCurrencyBySymbolsWithResponseDestinationNull() throws Exception {
		assertThrows(DataIntegrityViolationException.class, () -> exchange.requestCurrencyBySymbols("BRL", "U"));
	}

	@Test
	void testRequestCurrencyBySymbolsWithResponseOriginNull() throws Exception {
		assertThrows(DataIntegrityViolationException.class, () -> exchange.requestCurrencyBySymbols("b", "USD"));
	}

	@Test
	void testRequestCurrencyBySymbolsWithResponseErrorBadRequest() throws Exception {
		when(response.statusCode()).thenReturn(400);
		when(response.body()).thenReturn(getErrorResponse());
		assertThrows(DataIntegrityViolationException.class, () -> exchange.requestCurrencyBySymbols("BRL", "USD"));
	}

	@Test
	void testRequestCurrencyBySymbolsWithResponseErrorForbidden() throws Exception {
		when(response.statusCode()).thenReturn(403);
		when(response.body()).thenReturn(getErrorResponse());
		assertThrows(AccessDeniedException.class, () -> exchange.requestCurrencyBySymbols("BRL", "USD"));
	}

	@Test
	void testRequestCurrencyBySymbolsWithResponseErrorUnauthorized() throws Exception {
		when(response.statusCode()).thenReturn(401);
		when(response.body()).thenReturn(getErrorResponse());
		assertThrows(AuthorizationException.class, () -> exchange.requestCurrencyBySymbols("BRL", "USD"));
	}

	@Test
	void testRequestCurrencyBySymbolsWithResponseErrorObjectNotFound() throws Exception {
		when(response.statusCode()).thenReturn(404);
		when(response.body()).thenReturn(getErrorResponse());
		assertThrows(ObjectNotFoundException.class, () -> exchange.requestCurrencyBySymbols("BRL", "USD"));
	}
	
	@Test
	void testRequestCurrencyBySymbolsWithResponseErrorInternalServerError() throws Exception {
		when(response.statusCode()).thenReturn(500);
		when(response.body()).thenReturn(getErrorResponse());
		assertThrows(ServerErrorException.class, () -> exchange.requestCurrencyBySymbols("BRL", "USD"));
	}

	private Object getResponse() throws JSONException {
		return new Gson().toJson(dto);
	}

	private Object getErrorResponse() {
		return "{\"success\":false,\"error\":{\"code\":104,\"message\":\"Seu volume de solicitação mensal de API foi atingido. Atualize seu plano.\"}}";
	}

}
