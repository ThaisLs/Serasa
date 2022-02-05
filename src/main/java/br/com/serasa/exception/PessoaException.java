package br.com.serasa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PessoaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PessoaException(String exception) {
		super(exception);
	}

}
