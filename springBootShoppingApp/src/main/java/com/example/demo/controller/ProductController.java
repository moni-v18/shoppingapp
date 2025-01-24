package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;

import com.example.demo.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	Logger Logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product) {
		Logger.info("In controller /save" + product);
		return productService.addProduct(product);
	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		Logger.info("In controller /update" + product);
		return productService.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int productId) {
		Logger.info("In controller /delete" + productId);
		return productService.deleteProduct(productId);
	}

	@GetMapping("/getById/{id}")
	public Product getProductById(@PathVariable("id") int productId) throws ProductNotFound {
		Logger.info("In controller /getById" + productId);
		return productService.getProductById(productId);
	}

	@GetMapping("/getAllProducts")
	public List<Product> saveProduct() {
		Logger.info("In controller /getAllProducts");
		return productService.getAllProducts();
	}

	@GetMapping("/getAllProductsBetween/{price1}/{price2}")
	public List<Product> getAllProductsBetween(@PathVariable("price1") int initialPrice,
			@PathVariable("price2") int finalPrice) {
		Logger.info("In controller /getAllProductsBetween "+initialPrice+" "+finalPrice);
		return productService.getAllProductsBetweenPrice(initialPrice, finalPrice);
	}
	
	@GetMapping("/getProductsByCategory/{category}")
	public List<Product> getProductByCategory(@PathVariable("category") String category){
		Logger.info("In controller /getProductByCategory" + category);
		return productService.getProductsByCategory(category);
	}
	
	@GetMapping("/getAllProductsByCategoryAndPrice/{category}/{price}")
	public List<Product> getProductByCategoryAndPrice(@PathVariable("category") String category, @PathVariable("price") int price) {
		Logger.info("In controller /getAllProductsByCategoryAndPrice "+category+" "+price);
		return productService.getProductsByCategoryAndPrice(category, price);
	}

	
}