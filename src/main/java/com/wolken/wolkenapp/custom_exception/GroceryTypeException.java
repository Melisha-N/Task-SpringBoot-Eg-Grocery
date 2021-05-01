package com.wolken.wolkenapp.custom_exception;

public class GroceryTypeException extends Exception {
	@Override
	public String toString() {
		return "Grocery Type provided is Invalid";
	}
}
