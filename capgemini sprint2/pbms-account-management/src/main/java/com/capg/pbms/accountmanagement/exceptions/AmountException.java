package com.capg.pbms.accountmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "please Enter the amount with in 100 - 200000", value = HttpStatus.NOT_FOUND)
public class AmountException extends RuntimeException{
	
	public AmountException(String message) 
	{
		
		super(message);
	}

 
}
