package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.entity.Product;

public interface ProductService {
	public String addProduct(Product product);

	public Product updateProduct(Product product);

	public String deleteProduct(int productId);

	public Product getProductById(int productId) throws ProductNotFound;

	public List<Product> getAllProducts();

	public List<Product> getAllProductsBetweenPrice(int initialPrice, int finalPrice);
	
	public List<Product> getProductsByCategory(String category);
	
	public List<Product> getProductsByCategoryAndPrice(String category,int price);


}