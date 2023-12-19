package com.javatechie.api.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javatechie.api.exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handle(MethodArgumentNotValidException e){
		Map<String,String> map=new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(error->{
			map.put(error.getField(),error.getDefaultMessage());
		});
		return map;
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleBussiness(UserNotFoundException e){
		Map<String,String> map=new HashMap<>();
		map.put("message", e.getMessage());
		return map;
	}
	
	
	
	
	
	
	
	
}
