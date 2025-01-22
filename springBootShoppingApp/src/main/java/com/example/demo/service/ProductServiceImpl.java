package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo repository;

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		Product product1=repository.save(product);
		if(product1!=null) 
			return "Product saved successfully";
		else
			return "Failed to save";
	}
	


}
