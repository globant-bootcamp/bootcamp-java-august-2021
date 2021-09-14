package com.veterinary.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO<T> {

	private String message;
	private T response;
	private List<T> listResponse = new ArrayList<T>();

	public ResponseDTO(String message, T response) {
		this.message = message;
		this.response = response;
	}

	public ResponseDTO(String message, List<T> listResponse) {
		this.message = message;
		this.listResponse = listResponse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public List<T> getListResponse() {
		return listResponse;
	}

	public void setListResponse(List<T> listResponse) {
		this.listResponse = listResponse;
	}
}
