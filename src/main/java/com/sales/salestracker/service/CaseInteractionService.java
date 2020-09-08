/**
 * 
 */
package com.sales.salestracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.salestracker.dto.CaseInteractionDto;
import com.sales.salestracker.entity.CaseInteraction;
import com.sales.salestracker.repo.CaseInteractionRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

/**
 * @author cchaubey
 *
 */

@Service
public class CaseInteractionService {

	@Autowired
	private CaseInteractionRepo caseInteractionRepo;
	
	public List<CaseInteractionDto> getCaseInteractions() throws InstantiationException, IllegalAccessException{
		 List<CaseInteraction> CaseInteractions =  caseInteractionRepo.findAll();
		 return SalestrackerBeanUtil.copyEntityListToDTOList(CaseInteractions, CaseInteractionDto.class);
	}
	
	public void saveCaseInteractions(List<CaseInteractionDto> CaseInteractionDtos) throws InstantiationException, IllegalAccessException {
		List<CaseInteraction> CaseInteractions = SalestrackerBeanUtil.copyEntityListToDTOList(CaseInteractionDtos, CaseInteraction.class);
		caseInteractionRepo.saveAll(CaseInteractions);
	}
	
	public List<CaseInteractionDto> getCaseInteractionByCaseID(Long caseID) throws InstantiationException, IllegalAccessException{
		 List<CaseInteraction> CaseInteractions =  caseInteractionRepo.findByCaseID(caseID);
		 return SalestrackerBeanUtil.copyEntityListToDTOList(CaseInteractions, CaseInteractionDto.class);
	}
	
	public List<CaseInteractionDto> getCaseInteractionByDate(Date date) throws InstantiationException, IllegalAccessException{
		 List<CaseInteraction> CaseInteractions =  caseInteractionRepo.findByDate(date);
		 return SalestrackerBeanUtil.copyEntityListToDTOList(CaseInteractions, CaseInteractionDto.class);
	}
	
	public List<CaseInteractionDto> getCaseInteractionByCustomerID(Long customerID) throws InstantiationException, IllegalAccessException{
		 List<CaseInteraction> CaseInteractions =  caseInteractionRepo.findByCustomerID(customerID);
		 return SalestrackerBeanUtil.copyEntityListToDTOList(CaseInteractions, CaseInteractionDto.class);
	}
}
