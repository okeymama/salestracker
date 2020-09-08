/**
 * 
 */
package com.sales.salestracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.salestracker.dto.SalesInteractionDto;
import com.sales.salestracker.entity.SalesInteraction;
import com.sales.salestracker.repo.SalesInteractionRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

/**
 * @author cchaubey
 *
 */
@Service
public class SalesInteractionService {

	@Autowired
	private SalesInteractionRepo salesInteractionRepo;
	
	public List<SalesInteractionDto> getSalesInteractions() throws InstantiationException, IllegalAccessException{
		 List<SalesInteraction> salesInteractions =  salesInteractionRepo.findAll();
		 return SalestrackerBeanUtil.copyEntityListToDTOList(salesInteractions, SalesInteractionDto.class);
	}
	
	public void saveSalesInteractions(List<SalesInteractionDto> SalesInteractionDtos) throws InstantiationException, IllegalAccessException {
		List<SalesInteraction> salesInteractions = SalestrackerBeanUtil.copyEntityListToDTOList(SalesInteractionDtos, SalesInteraction.class);
		salesInteractionRepo.saveAll(salesInteractions);
	}
	
	public List<SalesInteractionDto> getSalesInteractionByDate(Date date) throws InstantiationException, IllegalAccessException{
		 List<SalesInteraction> salesInteractions =  salesInteractionRepo.findByCreatedDate(date);
		 return SalestrackerBeanUtil.copyEntityListToDTOList(salesInteractions, SalesInteractionDto.class);
	}
	
	public List<SalesInteractionDto> getSalesInteractionByCustomerID(Long customerID) throws InstantiationException, IllegalAccessException{
		 List<SalesInteraction> salesInteractions =  salesInteractionRepo.findByCustomerID(customerID);
		 return SalestrackerBeanUtil.copyEntityListToDTOList(salesInteractions, SalesInteractionDto.class);
	}
}
