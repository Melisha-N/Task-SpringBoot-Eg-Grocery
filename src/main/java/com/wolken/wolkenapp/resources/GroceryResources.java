package com.wolken.wolkenapp.resources;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.dto.GroceryDTO;
import com.wolken.wolkenapp.entity.GroceryEntity;
import com.wolken.wolkenapp.service.GroceryService;

@RestController 
@RequestMapping("/")                            //controller
public class GroceryResources {
	@Autowired
	GroceryService groceryService;
	
	@GetMapping("/display-grocery")
	@CrossOrigin
	public Iterable<GroceryEntity> displayAllGroceries(){
		
		return groceryService.validateAndDisplayAll();
	
	}
	
	@PostMapping("/add-grocery")
	@CrossOrigin
	public String addGrocery(@RequestBody GroceryDTO groceryDTO) {
		
		return groceryService.validateAndAdd(groceryDTO);
		
	}
	
	@GetMapping("/delete-grocery/{groceryName}")
	@Transactional
	@CrossOrigin
	public Iterable<GroceryEntity> deleteGroceryByGroceryName(@PathVariable String groceryName) {
		System.out.println("Inside deleteGroceryByGroceryName() of GroceryResources");
		System.out.println("Grocery Name:"+groceryName);
		return groceryService.validateAnddelete(groceryName);
		
	}
	
	@GetMapping("/search-grocery/{groceryName}")
	@CrossOrigin
	public GroceryEntity searchByGroceryName(@PathVariable String groceryName) {
		return groceryService.validateAndSearch(groceryName);
	}
	
	@PutMapping("/update-grocery")
	public GroceryEntity updateGroceryQuantityByGroceryName(@RequestBody GroceryEntity groceryEntity) {
		
		System.out.println("Inside updateGroceryQuantityByGroceryName() of GroceryResources");
		System.out.println("End of  updateGroceryQuantityByGroceryName() of GroceryResources");
		return groceryService.validateAndUpdateQuantity(groceryEntity.getGroceryQuantity() , groceryEntity.getGroceryName());
		
	}
}
