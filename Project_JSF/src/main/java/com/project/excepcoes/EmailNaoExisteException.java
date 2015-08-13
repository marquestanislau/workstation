package com.project.excepcoes;

public class EmailNaoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmailNaoExisteException(String message) {
		super(message);
	}
}
