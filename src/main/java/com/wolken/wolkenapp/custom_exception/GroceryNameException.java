package com.wolken.wolkenapp.custom_exception;

public class GroceryNameException extends Exception {
	
	@Override
	public String toString() {
		return "Grocery Name provided is Invalid";
	}

}
