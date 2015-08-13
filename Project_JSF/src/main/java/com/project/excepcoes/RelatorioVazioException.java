package com.project.excepcoes;

import java.io.Serializable;

public class RelatorioVazioException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public RelatorioVazioException(String message) {
		super(message);
	}
}
