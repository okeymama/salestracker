/**
 * 
 */
package com.sales.salestracker.entity;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author cchaubey
 *
 */
@Data
@Table(name="sales_interaction")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"salesIntID"})
public class SalesInteraction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sales_int_id")
	private Long salesIntID;
	
	@Column(name = "customer_id")
	private String customerID;
	
	@Column(name = "created_date")
	private Date createdDate; 
	
	@Column(name = "duration")
	private Duration duration;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "salesInteraction", orphanRemoval = true)
	private Set<SalesCase> salesCases;
	
	@Column(name = "created_by")
	private String createdBy;
	
}
