package com.wolken.wolkenapp.custom_exception;

public class GroceryCategoryException extends Exception {
	
	@Override
	public String toString() {
		return "Grocery Category provided is Invalid";
	}
}
