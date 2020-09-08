/**
 * 
 */
package com.sales.salestracker.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cchaubey
 *
 */
@Data
@Entity(name="case")
@NoArgsConstructor
@AllArgsConstructor
public class Case implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "case_id")
	private Long caseID;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "recommended_product")
	private String recommendedProduct;
	
	@Column(name = "case_desc")
	private String caseDesc;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = SalesInteraction.class)
    @JoinColumn(name = "sales_int_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private SalesInteraction salesInteraction;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parentCase", orphanRemoval = true)
	private List<CaseInteraction> caseInteractions;
	
	@Column(name = "last_updated_by")
	private Long lastUpdatedBy;
	
	@Column(name = "asssigned_to")
	private String asssignedTo;
	
}
