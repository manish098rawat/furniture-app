package com.furniture.exception;


public class  UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4774790458224075143L;

	public UserNotFoundException(String message){
        super(message);
    }
}