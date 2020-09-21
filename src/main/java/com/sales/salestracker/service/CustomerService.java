/**
 * 
 */
package com.sales.salestracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.salestracker.dto.CustomerDto;
import com.sales.salestracker.entity.Customer;
import com.sales.salestracker.repo.CustomerRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

/**
 * @author cchaubey
 *
 */
@Transactional
@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	List<CustomerDto> getCustomers() throws InstantiationException, IllegalAccessException{
		List<Customer> customers = customerRepo.findAll();
		return SalestrackerBeanUtil.copyEntityListToDTOList(customers, CustomerDto.class);
	}
	
	void saveCustomers(List<CustomerDto> customerDtos) throws InstantiationException, IllegalAccessException {
		List<Customer> customers = SalestrackerBeanUtil.copyEntityListToDTOList(customerDtos, Customer.class);
		customerRepo.saveAll(customers);
	}
	
	List<CustomerDto> getCustomerByName(Long organizationID) throws InstantiationException, IllegalAccessException{
		List<Customer> customers = customerRepo.findByOrganizationID(organizationID);
		return SalestrackerBeanUtil.copyEntityListToDTOList(customers, CustomerDto.class);
	}
	
}
