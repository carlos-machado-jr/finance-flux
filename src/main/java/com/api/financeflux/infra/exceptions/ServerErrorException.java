package com.api.financeflux.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServerErrorException(String msg) {
		super(msg);
	}

	public ServerErrorException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
