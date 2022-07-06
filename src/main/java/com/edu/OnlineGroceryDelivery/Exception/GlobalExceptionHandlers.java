package com.edu.OnlineGroceryDelivery.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlers {
	
	@ExceptionHandler(GivenIdNotFoundException.class)
	public ResponseEntity<Object> handleGivenIdNotFoundException() {
		return new ResponseEntity<Object> ("Given Id Is Not Available" , HttpStatus.NOT_FOUND);
	}
		
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<Object> handleNoRecordFoundException()  {
		return new ResponseEntity<Object> ("Given Record Is Not Available" , HttpStatus.NOT_FOUND);
	}
		@ExceptionHandler(NoProductsFoundException.class)
		public ResponseEntity<Object> handleNoProductsFoundException()  {
			return new ResponseEntity<Object> ("Given Product Is Not Available" , HttpStatus.NOT_FOUND);
		}
			
			@ExceptionHandler(NoAddressFoundException.class)
			public ResponseEntity<Object> handleNoAddressFoundException()  {
				return new ResponseEntity<Object> ("Given Address Is Not Available" , HttpStatus.NOT_FOUND);
				
				
			}
			
			@ExceptionHandler(RecordAlreadyExistException.class)
			
			public ResponseEntity<Object> handleRecordAlreadyExistException()  {
				return new ResponseEntity<Object> ("Record is Already Exist" , HttpStatus.FOUND);

			}
			
			@ExceptionHandler(NoSuchRecordFoundException.class)
			
			public ResponseEntity<Object> handleNoSuchRecordFoundException()  {
				return new ResponseEntity<Object> ("No Such Record is Available" , HttpStatus.FOUND);

			
				
				
				
			
	}
			
			@ExceptionHandler(NameNotFoundException.class)
			public ResponseEntity<Object> handleNameNotFoundException()  {
				return new ResponseEntity<Object> ("Given Name Is Not Available" , HttpStatus.NOT_FOUND);

			}
			
		
					
			

	
	@ExceptionHandler(value= {MethodArgumentNotValidException.class })
	public ResponseEntity<Map<String, String>> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	    	
	        String fieldName =  ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	        
	    });
	    return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
	}
	

}




		


