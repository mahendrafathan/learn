package com.glits.learn.dto;

public class SuccessResp {
	private String message;
	private Integer code;
	
	public SuccessResp(String msg, Integer code) {
		setMessage(msg);
		setCode(code);
	}
	
	public SuccessResp() {
		
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
}
