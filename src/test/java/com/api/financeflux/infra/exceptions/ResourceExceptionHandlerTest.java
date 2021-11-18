package com.api.financeflux.infra.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;

@SpringBootTest
class ResourceExceptionHandlerTest {

	@Mock
	private HttpServletRequest request;

	@InjectMocks
	private ResourceExceptionHandler handler;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testObjectNotFound() {
		assertNotNull(handler.objectNotFound(new ObjectNotFoundException(""), request));
	}

	@Test
	void testServerError() {
		assertNotNull(handler.serverError(new ServerErrorException(""), request));
	}

	@Test
	void testDataIntegrity() {
		assertNotNull(handler.dataIntegrity(new DataIntegrityViolationException(null), request));
	}

	@Test
	void testAuthorization() {
		assertNotNull(handler.authorization(new AuthorizationException(null), request));
	}

	@Test
	void testAccessDenied() {
		assertNotNull(handler.accessDenied(new AccessDeniedException(null), request));
	}

	@Test
	void testHttpMessageNotReadableException() {
		assertNotNull(handler.httpMessageNotReadableException(new HttpMessageNotReadableException(null, null, null),
				request));
	}

}
