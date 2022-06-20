package com.edu.OnlineGroceryDelivery.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
