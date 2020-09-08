/**
 * 
 */
package com.sales.salestracker.entity;

import java.util.Date;

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
@Entity(name="customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerID;
	
	@Column(name = "organization_id")
	private Long organizationID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "personal_number")
	private String personalNumber;
	
	@Column(name = "desk_number")
	private String deskNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "mail_subscriber")
	private Boolean isMailSubscriber;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@Column(name = "creation_date")
	private Date creationDate;

}
