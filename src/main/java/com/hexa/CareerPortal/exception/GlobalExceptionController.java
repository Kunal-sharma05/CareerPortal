package com.hexa.CareerPortal.exception;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
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
	 		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false),"Not_found");
	 		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	 	}
	 @ExceptionHandler(EmployerNotFoundException.class)
	 	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(EmployerNotFoundException e, WebRequest w)
	 	{
	 		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false),"Not_found");
	 		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	 	}
	 @ExceptionHandler(JobNotFoundException.class)
	 	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(JobNotFoundException e, WebRequest w)
	 	{
	 		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false),"Not_found");
	 		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	 	}
	 @ExceptionHandler(JobApplicationNotFoundException.class)
	 	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(JobApplicationNotFoundException e, WebRequest w)
	 	{
	 		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false),"Not_found");
	 		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	 	}
	 @ExceptionHandler(JobSeekerNotFoundException.class)
	 	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(JobSeekerNotFoundException e, WebRequest w)
	 	{
	 		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false),"Not_found");
	 		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	 	}
	 @ExceptionHandler(ResumeNotFoundException.class)
	 	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResumeNotFoundException e, WebRequest w)
	 	{
	 		ErrorDetails er= new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false),"Not_found");
	 		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
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
