package com.hexa.CareerPortal.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
	 @ExceptionHandler(ResourceNotFoundException.class)
 	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest w)
 	{
 		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false),"Not_found");
 		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
 	}
	 @ExceptionHandler(NameAlreadyExistException.class)
	 	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(NameAlreadyExistException e, WebRequest w)
	 	{
	 		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false),"Product name already exist");
	 		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
	 	}
	 @Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
			BindingResult bindingResult=ex.getBindingResult();
			List<FieldError> fieldError=bindingResult.getFieldErrors();
			Map<String,String> validationError=new HashMap<>();
			fieldError.forEach(f->validationError.put(f.getField(),f.getDefaultMessage()));
			ErrorDetails exceptionResponse=new ErrorDetails(LocalDateTime.now(),"Validation failed",validationError.toString());
			return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
		}
}
