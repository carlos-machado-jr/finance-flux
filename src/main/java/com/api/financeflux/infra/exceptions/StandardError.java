package com.api.financeflux.infra.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String message;
	private String detailMessage;
	private Long timeStamp;

	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.message = msg;
		this.timeStamp = timeStamp;
	}
	public StandardError(Integer status, String msg, String detailMessage, Long timeStamp) {
		super();
		this.status = status;
		this.message = msg;
		this.detailMessage = detailMessage;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
