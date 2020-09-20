/**
 * 
 */
package com.sales.salestracker.dto;

import java.util.Date;

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

	private Long caseID;
	
	private Long customerID;
	
	private Date creationDate;
	
	private String status;
	
	private String recommendedProduct;
	
	private String problemDesc;
	
	private Long parentInteractionID;
	
	private String asssignedTo;
	
}
