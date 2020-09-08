package com.sales.salestracker.dto;

import java.time.Duration;
import java.util.Date;

import com.sales.salestracker.entity.Case;

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
	
	private Case parentCase;
	
	private String createdBy;
	
}
