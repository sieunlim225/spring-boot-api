package com.kosta.response;

public class ApiResponse {

	private String status;
	private String error;
	
	public ApiResponse() {
		status = "OK";
		error = "";
	}
	
	public ApiResponse(String error) {
		status = "Failed";
		this.error = error;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
