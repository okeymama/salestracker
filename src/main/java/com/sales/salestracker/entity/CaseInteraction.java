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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="case_interaction")
@NoArgsConstructor
@AllArgsConstructor
public class CaseInteraction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "case_int_id")
	private Long caseIntID;
	
	@Column(name = "created_date")
	private Date createdDate; 
	
	@Column(name = "duration")
	private Duration duration;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = SalesCase.class)
    @JoinColumn(name = "case_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private SalesCase parentCase;
	
	@Column(name = "created_by")
	private String createdBy;
	
}
