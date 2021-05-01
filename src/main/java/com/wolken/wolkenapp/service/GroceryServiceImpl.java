package com.wolken.wolkenapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.custom_exception.GroceryCategoryException;
import com.wolken.wolkenapp.custom_exception.GroceryNameException;
import com.wolken.wolkenapp.custom_exception.GroceryQuantityException;
import com.wolken.wolkenapp.custom_exception.GroceryRatingsException;
import com.wolken.wolkenapp.custom_exception.GroceryTypeException;
import com.wolken.wolkenapp.dao.GroceryDAO;
import com.wolken.wolkenapp.dto.GroceryDTO;
import com.wolken.wolkenapp.entity.GroceryEntity;

@Service
public class GroceryServiceImpl implements GroceryService{
	
	@Autowired
	GroceryDAO groceryDAO;
	
	@Override
	public Iterable<GroceryEntity> validateAndDisplayAll() {
		return groceryDAO.displayAll();
	}

	@Override
	public String validateAndAdd(GroceryDTO groceryDTO) {
		try {
			if(groceryDTO != null) {
				if(groceryDTO.getGroceryCategory().isEmpty() || groceryDTO.getGroceryCategory().length() < 3 ) {
					throw new GroceryCategoryException();
				}
				if(groceryDTO.getGroceryName().isEmpty() || groceryDTO.getGroceryName().length() < 3 ) {
					throw new GroceryNameException();
				}
				if(groceryDTO.getGroceryType().isEmpty() || groceryDTO.getGroceryType().length() < 3 ) {
					throw new GroceryTypeException();
				}
				if(groceryDTO.getGroceryQuantity().isEmpty() || groceryDTO.getGroceryQuantity().length() < 2 ) {
					throw new GroceryQuantityException();
				}
				if(groceryDTO.getGroceryRatings() < 1) {
					throw new GroceryRatingsException();
				}
				else {
					String addMsg = groceryDAO.add(groceryDTO);
					return addMsg;
				}
			}
		} catch (GroceryCategoryException| GroceryNameException| GroceryTypeException| GroceryQuantityException| GroceryRatingsException| NullPointerException e) {
			System.out.println(e);
		}
		
			return "Grocery Details Cannot Be Added!";
		
		
	}

	@Override
	public Iterable<GroceryEntity> validateAnddelete(String groceryName) {

		System.out.println("Inside validateAnddelete() of GroceryServiceImpl");
		System.out.println("Calling delByGroceryName()");
		
		return groceryDAO.delByGroceryName(groceryName);
		
//		try {
//		if(groceryName.length() < 3) {
//			System.out.println("Executing GroceryNameException()");
//			throw new GroceryNameException();	
//	}
//			
//	} catch (GroceryNameException | Exception e) {
//		 System.out.println(e);
//	}
		
			
	}

	@Override
	public GroceryEntity validateAndSearch(String groceryName) {
		
		return groceryDAO.searchByGroceryName(groceryName);
	}

	@Override
	public GroceryEntity validateAndUpdateQuantity(String groceryQuantity, String groceryName) {
		System.out.println("Inside validateAndUpdateQuantity GroceryServiceImpl");
		System.out.println("Calling updateByQuantity()");
		System.out.println("End of validateAndUpdateQuantity GroceryServiceImpl");

		return groceryDAO.updateByQuantity(groceryQuantity , groceryName);
//		try {
//			if(groceryQuantity.isEmpty() || groceryQuantity.length() < 2) {
//				throw new GroceryQuantityException();
//			}
//			if(groceryName.isEmpty() || groceryName.length() < 3 ) {
//				throw new GroceryQuantityException();
//			}
//			else {
//				
//			}
//		} catch (Exception e) {
//		System.out.println(e);
//		}
//		return null;
	}

}
