package com.wolken.wolkenapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.wolken.wolkenapp.entity.GroceryEntity;

public interface GroceryRepository extends JpaRepository<GroceryEntity, Integer> {

	public GroceryEntity findByGroceryName(String groceryName);

	public Iterable<GroceryEntity> deleteByGroceryName(String groceryName);

//	public GroceryEntity findByGroceryQuantity(String groceryQuantity);

//	public void deleteByGroceryName(String groceryName);


}
