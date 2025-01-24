package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	public List<Product> findByProductPriceBetween(int initialPrice,int finalPrice);
	
	public List<Product> findByProductCategory(String category);
	
    public List<Product> findByProductCategoryAndProductPriceLessThan(String category, double price);

}