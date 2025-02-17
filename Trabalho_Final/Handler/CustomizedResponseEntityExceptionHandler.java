package br.luisa.GerenciamentoProjetos.Handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.luisa.GerenciamentoProjetos.Exceptions.ExceptionResponse;
import br.luisa.GerenciamentoProjetos.Exceptions.ResourceNotFoundException;
import br.luisa.GerenciamentoProjetos.Exceptions.UnsupportedOperationsException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
			Exception ex, WebRequest request){					
				ExceptionResponse exceptionResponse = new 
						ExceptionResponse(
								new Date(),
								ex.getMessage(),
								request.getDescription(false));
				return new ResponseEntity<>(exceptionResponse,
						HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UnsupportedOperationsException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
			Exception ex, WebRequest request){								
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}

}