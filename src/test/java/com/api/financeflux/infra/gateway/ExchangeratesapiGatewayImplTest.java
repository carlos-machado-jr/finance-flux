package com.api.financeflux.infra.gateway;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import com.api.financeflux.infra.dto.ExchangeratesapiResponseDto;

import reactor.core.publisher.Mono;

@SpringBootTest
class ExchangeratesapiGatewayImplTest {

	@InjectMocks
	private ExchangeratesapiGatewayImpl exchange;

	@Mock
	private WebClient client;

	private ExchangeratesapiResponseDto resp;

	@BeforeEach
	void setUp() throws Exception {
		resp = new ExchangeratesapiResponseDto();
		resp.setRates(Map.of("BRL", BigDecimal.valueOf(6), "USD", BigDecimal.valueOf(1)));
		final var requestBodyUriSpecMock = mock(WebClient.RequestBodyUriSpec.class);
		final var responseSpecMock = mock(WebClient.ResponseSpec.class);
		when(client.method(any())).thenReturn(requestBodyUriSpecMock);
		when(client.method(any()).uri(anyString())).thenReturn(requestBodyUriSpecMock);
		when(client.method(any()).uri(anyString()).retrieve()).thenReturn(responseSpecMock);
		when(client.method(any()).uri(anyString()).retrieve()
				.bodyToMono(ArgumentMatchers.<Class<ExchangeratesapiResponseDto>>notNull()))
						.thenReturn(Mono.just(resp));

	}

	@Test
	void testRequestCurrencyBySymbols() throws Exception {
		exchange.requestCurrencyBySymbols("BRL", "USD");
	}

	@Test
	void testRequestCurrencyBySymbolsWithValuesNull() throws Exception {
		assertThrows(Exception.class, () -> exchange.requestCurrencyBySymbols(null, null));
	}

	@Test
	void testRequestCurrencyBySymbolsWithOriginNull() throws Exception {
		assertThrows(Exception.class, () -> exchange.requestCurrencyBySymbols(null, "USD"));
	}

	@Test
	void testRequestCurrencyBySymbolsWithDestinationNull() throws Exception {
		assertThrows(Exception.class, () -> exchange.requestCurrencyBySymbols("BRL", null));
	}

}
