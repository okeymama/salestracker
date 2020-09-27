/**
 * 
 */
package com.sales.salestracker.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sales.salestracker.dto.ProductDto;
import com.sales.salestracker.entity.Product;
import com.sales.salestracker.repo.ProductRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

/**
 * @author cchaubey
 *
 */
@Transactional
@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/Products")
	public List<ProductDto> getAllProduct() throws InstantiationException, IllegalAccessException{
		List<ProductDto> productDtos  = null;
		List<Product> products  = productRepo.findAll();
		if(!CollectionUtils.isEmpty(products)) {
			productDtos = SalestrackerBeanUtil.copyEntityListToDTOList(products, ProductDto.class);
		}
		return productDtos;
	}
	
	@PostMapping("/Products")
	public void saveProduct(@RequestBody List<ProductDto> productDtos) throws InstantiationException, IllegalAccessException {
		List<Product> products = SalestrackerBeanUtil.copyEntityListToDTOList(productDtos, Product.class);
		productRepo.saveAll(products);
	}
	
	
}
