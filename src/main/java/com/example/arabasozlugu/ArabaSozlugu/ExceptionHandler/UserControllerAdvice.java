package com.example.arabasozlugu.ArabaSozlugu.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.example.arabasozlugu.ArabaSozlugu.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserControllerAdvice {
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<String> handleUserNotFound(MethodArgumentNotValidException ex,HttpServletRequest req){
		if(req.getServletPath().equals("/user/signup")) {
			String field = ex.getBindingResult().getFieldError().getField();
			return new ResponseEntity<String>(field + " Bos Bırakilamaz",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("1",HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
		return new ResponseEntity<String>("Böyle bir username bulunamadı.:" + ex.getUser().getUser() ,HttpStatus.NOT_FOUND);
	}
}
