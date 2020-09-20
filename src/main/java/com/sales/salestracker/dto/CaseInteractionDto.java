package com.sales.salestracker.dto;

import java.time.Duration;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder.Case;

import com.sales.salestracker.entity.SalesCase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseInteractionDto {

	private Long caseIntID;
	
	private Date createdDate; 
	
	private Duration duration;
	
	private String description;
	
	private SalesCase parentCase;
	
	private String createdBy;
	
}
