/**
 * 
 */
package com.sales.salestracker.dto;

import java.time.Duration;
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
public class SalesInteractionDto {

	private Long interactionID;
	
	private String customerID;
	
	private Date createdDate; 
	
	private Duration duration;
	
	private String description;
	
	private Long associatedCaseID;
	
	private String createdBy;
	
}
