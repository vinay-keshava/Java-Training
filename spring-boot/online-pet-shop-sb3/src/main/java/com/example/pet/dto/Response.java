package com.example.pet.dto;

import java.util.List;

public class Response {

	private List<String> messages;
	private int code;
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Response(List<String> messages, int code) {
		super();
		this.messages = messages;
		this.code = code;
	}
	
}
