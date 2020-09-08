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
public class CustomerDto {

	private Long customerID;
	
	private Long organizationID;
	
	private String firstName;

	private String lastName;
	
	private String personalNumber;
	
	private String deskNumber;
	
	private String email;
	
	private String designation;
	
	private String department;

	private Boolean isMailSubscriber;
	
	private Long createdBy;
	
	private Date creationDate;
	
}
