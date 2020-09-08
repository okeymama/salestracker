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
public class ProductDto {

	private Long productID;
	
	private String productDetail;
	
	private String modelNumber;
	
	private String createdBy;
	
	private Date creationDate;
	
}
