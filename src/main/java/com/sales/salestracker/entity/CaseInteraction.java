package com.sales.salestracker.entity;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name="case_interaction")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"caseIntID"})
public class CaseInteraction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "case_int_id")
	private Long caseIntID;
	
	@Column(name = "customer_id")
	private String customerID;
	
	@Column(name = "duration")
	private Duration duration;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = SalesCase.class)
    @JoinColumn(name = "sales_case_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private SalesCase salesCase;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private Date createdDate; 
	
}
