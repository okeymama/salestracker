/**
 * 
 */
package com.sales.salestracker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.salestracker.dto.SalesCaseDto;
import com.sales.salestracker.entity.SalesCase;
import com.sales.salestracker.repo.SalesCaseRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

/**
 * @author cchaubey
 *
 */
@Transactional
@Service
public class CaseService {

	private SalesCaseRepo salesCaseRepo;
	
	List<SalesCaseDto> getCases() throws InstantiationException, IllegalAccessException{ 
		List<SalesCase> cases =  salesCaseRepo.findAll();
		return SalestrackerBeanUtil.copyEntityListToDTOList(cases, SalesCase.class);
	}
	
	void saveCases(List<SalesCaseDto> caseDtos) throws InstantiationException, IllegalAccessException {
		List<SalesCase> cases = SalestrackerBeanUtil.copyEntityListToDTOList(caseDtos, SalesCase.class);
		salesCaseRepo.saveAll(cases);
	}
	
}
