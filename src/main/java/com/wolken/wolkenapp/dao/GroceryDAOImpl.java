package com.wolken.wolkenapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dto.GroceryDTO;
import com.wolken.wolkenapp.entity.GroceryEntity;
import com.wolken.wolkenapp.repository.GroceryRepository;

@Component
public class GroceryDAOImpl implements GroceryDAO {

	@Autowired
	GroceryRepository groceryRepo;

	@Override
	public Iterable<GroceryEntity> displayAll() {

		return groceryRepo.findAll();

	}

	@Override
	public String add(GroceryDTO groceryDTO) {
		GroceryEntity groceryEntity = new GroceryEntity();

		groceryEntity.setGroceryCategory(groceryDTO.getGroceryCategory());
		groceryEntity.setGroceryName(groceryDTO.getGroceryName());
		groceryEntity.setGroceryType(groceryDTO.getGroceryType());
		groceryEntity.setGroceryQuantity(groceryDTO.getGroceryQuantity());
		groceryEntity.setGroceryRatings(groceryDTO.getGroceryRatings());

		groceryRepo.save(groceryEntity);

		return "Grocery Added Succesfully!";
	}

	@Override
	public Iterable<GroceryEntity> delByGroceryName(String groceryName) {
		System.out.println("Inside delByGroceryName() of GroceryDAOImpl");
		System.out.println("groceryRepo.findByGroceryName(groceryName)" + groceryRepo.findByGroceryName(groceryName));
		System.out.println("Deleting Data: groceryRepo.delete()");
		groceryRepo.delete(groceryRepo.findByGroceryName(groceryName));
		System.out.println("Data Deleted");
		return groceryRepo.findAll();
	}

	@Override
	public GroceryEntity searchByGroceryName(String groceryName) {

		return groceryRepo.findByGroceryName(groceryName);
	}

	@Override
	public GroceryEntity updateByQuantity(String groceryQuantity, String groceryName) {
		System.out.println("Inside updateByQuantity() of GroceryDAOImpl");
		System.out.println("groceryEntity:"+groceryRepo.findByGroceryName(groceryName));
		GroceryEntity groceryEntity = groceryRepo.findByGroceryName(groceryName);
		System.out.println("Updating groceryQuantity - "+groceryQuantity);
		groceryEntity.setGroceryQuantity(groceryQuantity);
		System.out.println("Updated the data");
		System.out.println("Updated groceryQuantity - "+groceryQuantity);
		System.out.println("End of updateByQuantity() of GroceryDAOImpl");
		return groceryRepo.save(groceryEntity);

	}

}
