package com.wolken.wolkenapp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Component
public class GroceryDTO {
	
	private String groceryCategory;
	private String groceryName;
	private String groceryType;
	private String groceryQuantity;
	private float groceryRatings;

}
