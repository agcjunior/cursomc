package com.aj.cursomc.services.exceptions;

public class DataIntegrityExcpeption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityExcpeption(String msg) {
		super(msg);
	}
	public DataIntegrityExcpeption(String msg, Throwable cause) {
		super(msg, cause);
	}
}
