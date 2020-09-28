/**
 * 
 */
package com.sales.salestracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.salestracker.dto.CustomerDto;
import com.sales.salestracker.service.CustomerService;

/**
 * @author cchaubey
 *
 */
@CrossOrigin(value="*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/Customers")
	private List<CustomerDto> getCustomers() throws InstantiationException, IllegalAccessException{
		return customerService.getCustomers();
	}
	
	@GetMapping("/Customers/{organizationID}")
	private List<CustomerDto> getCustomersByOrgId(@PathVariable("organizationID")Long organizationID) throws InstantiationException, IllegalAccessException{
		return customerService.getCustomersByOrgId(organizationID);
	}
	
	@PostMapping("/Customers")
	private void saveCustomers(@RequestBody List<CustomerDto> customerDtos) throws InstantiationException, IllegalAccessException {
		customerService.saveCustomers(customerDtos);
	}
	
	
}
