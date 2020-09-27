/**
 * 
 */
package com.sales.salestracker.dto;

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
public class OrganizationDto {

	private Long organizationID;
	
	private String organizationName;
	
	private String organizationDetail;
	
	private String addressLine1;
	
	private String pinCode;
	
	private String city;
	
	private String state;
	
	private String createdBy;
	
	private String creationDate;
	
}
