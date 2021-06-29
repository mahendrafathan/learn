package com.glits.learn.dto;

public class ErrorResp {
	private String errMessage;
	
	public ErrorResp(String message) {
		this.errMessage = message;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
}
