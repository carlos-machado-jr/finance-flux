package com.api.financeflux.infra.configuration;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.api.financeflux.FinanceFluxApplication;
import com.api.financeflux.application.outbound.CurrencyRestGateway;
import com.api.financeflux.application.outbound.TransactionRepository;
import com.api.financeflux.application.service.CurrencyServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = FinanceFluxApplication.class)
public class BeanConfiguration {

	@Bean
	public HttpClient httpClient() {
		return HttpClient.newHttpClient();
	}
	
	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.build();
	}
	@Bean
	public CurrencyServiceImpl currencyServiceImpl(CurrencyRestGateway gateway, TransactionRepository repository) {
		return new CurrencyServiceImpl(gateway, repository);
	}
//	@Bean
//	public ExchangeratesapiGatewayImpl exchangeratesapiGatewayImpl() {
//		return new ExchangeratesapiGatewayImpl();
//	}
}
