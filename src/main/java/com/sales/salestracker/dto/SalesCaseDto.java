/**
 * 
 */
package com.sales.salestracker.dto;

import java.util.Date;
import java.util.List;

import com.sales.salestracker.entity.CaseInteraction;
import com.sales.salestracker.entity.SalesInteraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cchaubey
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesCaseDto {

private Long salesCaseID;
	
	private Date creationDate;
	
	private Date lastUpdatedDate;
	
	private String status;
	
	private String recommendedProduct;
	
	private String caseDesc;
		
	private List<CaseInteractionDto> caseInteractionDtos;
	
	private String lastUpdatedBy;
	
	private String asssignedTo;
	
}
