package com.wolken.wolkenapp.dao;

import java.util.List;

import com.wolken.wolkenapp.dto.GroceryDTO;
import com.wolken.wolkenapp.entity.GroceryEntity;

public interface GroceryDAO {

	public Iterable<GroceryEntity> displayAll();

	public String add(GroceryDTO groceryDTO);

	public Iterable<GroceryEntity> delByGroceryName(String groceryName);

	public GroceryEntity searchByGroceryName(String groceryName);

	public GroceryEntity updateByQuantity(String groceryQuantity, String groceryName);

}
