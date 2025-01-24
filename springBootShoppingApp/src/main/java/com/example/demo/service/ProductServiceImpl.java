package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // lombok creates a constructor and takes care of constructor injection
public class ProductServiceImpl implements ProductService {

	private ProductRepo productRepository;

	@Override
	public String addProduct(Product product) {
	
		Product result = productRepository.save(product);
		if (result != null)
			return "product added successfully";
		else
			return "product not added";
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public String deleteProduct(int productId) {
		productRepository.deleteById(productId);
		return "Product Deleted Successfully";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFound {
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("No Product found with the given Id!");
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetweenPrice(int initialPrice, int finalPrice) {
		return productRepository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.findByProductCategory(category);
	}

	@Override
	public List<Product> getProductsByCategoryAndPrice(String category, int price) {
		return productRepository.findByProductCategoryAndProductPriceLessThan(category, price);
	}

}