package com.api.financeflux.infra.configuration;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.api.financeflux.FinanceFluxApplication;
import com.api.financeflux.application.outbound.CurrencyRestGateway;
import com.api.financeflux.application.outbound.UserRepository;
import com.api.financeflux.application.service.CurrencyServiceImpl;
import com.api.financeflux.application.service.UserServiceImpl;
import com.api.financeflux.infra.inbound.UserService;

@Configuration
@ComponentScan(basePackageClasses = FinanceFluxApplication.class)
public class BeanConfiguration {

	@Bean
	public HttpClient httpClient() {
		return HttpClient.newHttpClient();
	}
	
	@Bean
	public CurrencyServiceImpl currencyServiceImpl(CurrencyRestGateway gateway, UserService userService) {
		return new CurrencyServiceImpl(gateway, userService);
	}
	
	@Bean
	public UserServiceImpl userServiceImpl(UserRepository userRepository) {
		return new UserServiceImpl(userRepository);
	}
	
}
