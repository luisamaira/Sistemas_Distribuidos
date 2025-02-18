package br.luisa.GerenciamentoProjetos.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedOperationsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnsupportedOperationsException(String ex) {
		super(ex);
	}

}
