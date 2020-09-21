package com.sales.salestracker.dto;

import java.time.Duration;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.CriteriaBuilder.Case;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sales.salestracker.entity.SalesCase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseInteractionDto {

	private Long caseIntID;
	
	private String customerID;
	
	private Duration duration;
	
	private String description;
		
	private String createdBy;
	
	private Date createdDate; 
	
}
