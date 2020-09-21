/**
 * 
 */
package com.sales.salestracker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.salestracker.dto.CaseInteractionDto;
import com.sales.salestracker.dto.SalesCaseDto;
import com.sales.salestracker.dto.SalesInteractionDto;
import com.sales.salestracker.entity.CaseInteraction;
import com.sales.salestracker.entity.SalesCase;
import com.sales.salestracker.entity.SalesInteraction;
import com.sales.salestracker.repo.SalesInteractionRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

/**
 * @author cchaubey
 *
 */
@Transactional
@Service
public class SalesInteractionService {

	@Autowired
	private SalesInteractionRepo salesInteractionRepo;
	
	public List<SalesInteractionDto> getSalesInteractions() throws InstantiationException, IllegalAccessException{
		List<SalesInteractionDto> salesInteractionDtos = null;
		List<SalesInteraction> salesInteractions =  salesInteractionRepo.findAll();
		 if(!CollectionUtils.isEmpty(salesInteractions)) {
			 salesInteractionDtos = new ArrayList<>();
			 for(SalesInteraction salesInteraction: salesInteractions) {
				 SalesInteractionDto salesInteractionDto = new SalesInteractionDto();
				 SalestrackerBeanUtil.copyProperties(salesInteraction, salesInteractionDto);
				 Set<SalesCase> salesCases = salesInteraction.getSalesCases();
				 if(!CollectionUtils.isEmpty(salesCases)) {
					 List<SalesCaseDto> salesCaseDtos = new ArrayList<>();
					 for(SalesCase salesCase : salesCases) {
						 SalesCaseDto salesCaseDto = new SalesCaseDto();
						 Set<CaseInteraction> caseInteractions  = salesCase.getCaseInteractions();
						 SalestrackerBeanUtil.copyProperties(salesCase, salesCaseDto);
						 if(!CollectionUtils.isEmpty(caseInteractions)) {
							 List<CaseInteractionDto> caseInteractionDtos = SalestrackerBeanUtil.copyEntityListToDTOList(caseInteractions, CaseInteractionDto.class);
							 salesCaseDto.setCaseInteractionDtos(caseInteractionDtos);
						 }
						 salesCaseDtos.add(salesCaseDto);
					 }
					 salesInteractionDto.setSalesCaseDtos(salesCaseDtos);
				 }
				 salesInteractionDtos.add(salesInteractionDto);
			 }
		 }
		 return salesInteractionDtos;
	}
	
	public void saveSalesInteractions(List<SalesInteractionDto> salesInteractionDtos) throws InstantiationException, IllegalAccessException {
		if(!CollectionUtils.isEmpty(salesInteractionDtos)) {
			SalesInteraction salesInteraction = null;
			List<SalesInteraction> salesInteractions = new ArrayList<>();
			for(SalesInteractionDto salesInteractionDto : salesInteractionDtos) {
				salesInteraction = new SalesInteraction();
				SalestrackerBeanUtil.copyProperties(salesInteractionDto, salesInteraction);
				if(!CollectionUtils.isEmpty(salesInteractionDto.getSalesCaseDtos())) {
					Set<SalesCase> salesCases = new HashSet<>();
					for(SalesCaseDto salesCaseDto: salesInteractionDto.getSalesCaseDtos()) {
						SalesCase salesCase = new SalesCase();
						SalestrackerBeanUtil.copyProperties(salesCaseDto, salesCase);
						salesCase.setSalesInteraction(salesInteraction);
						salesCases.add(salesCase);
					}
					salesInteraction.setSalesCases(salesCases);
				}
				salesInteractions.add(salesInteraction);
			}
			salesInteractionRepo.saveAll(salesInteractions);
		}
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
