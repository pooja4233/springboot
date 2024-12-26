package com.sathya.springboot.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
	private String NAME;
	private String BRAND;
	private String MADEIN;
	private double PRICE;
	private int QUANTITY;
	private int DISCOUNTRATE;
	
	

	

}
