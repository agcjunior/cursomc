package com.aj.cursomc.services.exceptions;

public class ObjectNotFoundExcpeption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExcpeption(String msg) {
		super(msg);
	}
	public ObjectNotFoundExcpeption(String msg, Throwable cause) {
		super(msg, cause);
	}
}
