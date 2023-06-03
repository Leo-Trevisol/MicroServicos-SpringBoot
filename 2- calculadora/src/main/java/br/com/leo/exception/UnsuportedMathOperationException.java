package br.com.leo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7933231721822877032L;
	
	public UnsuportedMathOperationException(String exception) {
		super(exception);
	}

}
