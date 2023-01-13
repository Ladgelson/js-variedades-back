package jsvariedades.sales.controller.v1.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;


import jakarta.servlet.http.HttpServletRequest;
import jsvariedades.sales.exceptions.NotFound;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NotFound.class)
	public ResponseEntity<StandardError> objNotFound(NotFound e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityViolationException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<StandardError> sqlError(SQLIntegrityConstraintViolationException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.CONFLICT.value(), "Error: Some field is being filled wrong, please fill in correctly.", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodValidation( MethodArgumentNotValidException e, HttpServletRequest request){
		
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation errors", LocalDateTime.now());
		
		for(FieldError x :  e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
