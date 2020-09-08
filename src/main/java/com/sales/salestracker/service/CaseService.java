/**
 * 
 */
package com.sales.salestracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sales.salestracker.dto.CaseDto;
import com.sales.salestracker.entity.Case;
import com.sales.salestracker.repo.CaseRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

/**
 * @author cchaubey
 *
 */
@Service
public class CaseService {

	private CaseRepo caseRepo;
	
	List<CaseDto> getCases() throws InstantiationException, IllegalAccessException{ 
		List<Case> cases =  caseRepo.findAll();
		return SalestrackerBeanUtil.copyEntityListToDTOList(cases, Case.class);
	}
	
	void saveCases(List<CaseDto> caseDtos) throws InstantiationException, IllegalAccessException {
		List<Case> cases = SalestrackerBeanUtil.copyEntityListToDTOList(caseDtos, Case.class);
		caseRepo.saveAll(cases);
	}
	
}
