package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.GroceryDTO;
import com.wolken.wolkenapp.entity.GroceryEntity;

public interface GroceryService {
	
	public Iterable<GroceryEntity> validateAndDisplayAll();

	public String validateAndAdd(GroceryDTO groceryDTO);

	public Iterable<GroceryEntity> validateAnddelete(String groceryName);

	public GroceryEntity validateAndSearch(String groceryName);

	public GroceryEntity validateAndUpdateQuantity(String groceryQuantity, String groceryName);

}
