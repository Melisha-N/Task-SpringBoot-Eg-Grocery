package com.wolken.wolkenapp.custom_exception;

public class GroceryQuantityException extends Exception {
	@Override
	public String toString() {
		return "Grocery Quantity provided is Invalid";
	}

}
