package com.wolken.wolkenapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="grocery_table")
public class GroceryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grocery_id")
	private int groceryId;
	
	@Column(name = "grocery_category")
	private String groceryCategory;
	
	@Column(name = "grocery_name")
	private String groceryName;
	
	@Column(name = "grocery_type")
	private String groceryType;
	
	@Column(name = "grocery_quantity")
	private String groceryQuantity;
	
	@Column(name = "grocery_ratings")
	private float groceryRatings;

}
