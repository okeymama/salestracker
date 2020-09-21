/**
 * 
 */
package com.sales.salestracker.dto;

import java.time.Duration;
import java.util.Date;
import java.util.List;

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
public class SalesInteractionDto {

	private Long salesIntID;
	
	private String customerID;
	
	private Date createdDate; 
	
	private Duration duration;
	
	private List<SalesCaseDto> salesCaseDtos;
	
	private String createdBy;
}
