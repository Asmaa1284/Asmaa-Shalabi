package com.kani.springBoot.exception;

public class CartNotFoundException extends RuntimeException {
	public CartNotFoundException(String message) {
		super(message);
		

}
}