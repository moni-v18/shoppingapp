package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
@Entity
@Table(name="products")
public class Product {
	
	@Id
	private int productId;
	@NotEmpty
	private String productName;
	@Min(10)
	@Max(10000000)
	private int productPrice;
	@NotEmpty
	private String productCategory;
	private LocalDate productValidity;
}
