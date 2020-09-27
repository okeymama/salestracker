/**
 * 
 */
package com.sales.salestracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.salestracker.dto.ProductDto;
import com.sales.salestracker.service.ProductService;

/**
 * @author cchaubey
 *
 */
@CrossOrigin(value="*")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/Products")
	public List<ProductDto> getAllProduct() throws InstantiationException, IllegalAccessException{
		return productService.getAllProduct();
	}
	
	@PostMapping("/Products")
	public void saveProduct(@RequestBody List<ProductDto> productDtos) throws InstantiationException, IllegalAccessException {
		productService.saveProduct(productDtos);
	}
	
}
