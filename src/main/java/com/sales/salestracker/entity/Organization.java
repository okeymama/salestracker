/**
 * 
 */
package com.sales.salestracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cchaubey
 *
 */
@Data
@Entity(name="organization")
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "organization_id")
	private Long organizationID;
	
	@Column(name = "organization_name")
	private String organizationName;
	
	@Column(name = "organization_detail")
	private String organizationDetail;
	
	@Column(name = "address_line1")
	private String addressLine1;
	
	@Column(name = "pincode")
	private String pinCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "creation_date")
	private String creationDate;
	
}
