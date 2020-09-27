/**
 * 
 */
package com.sales.salestracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.salestracker.dto.SalesInteractionDto;
import com.sales.salestracker.service.SalesInteractionService;

/**
 * @author cchaubey
 *
 */
@CrossOrigin(value="*")
@RestController
public class SalesInteractionController {

	@Autowired
	private SalesInteractionService salesInteractionService;
	
	@GetMapping("/SalesInteractions" )
	public List<SalesInteractionDto> getSalesInteractions() throws InstantiationException, IllegalAccessException{
		return salesInteractionService.getSalesInteractions();
	}
	
	
	@PostMapping("/SalesInteractions")
	public void saveSalesInteractions(@RequestBody List<SalesInteractionDto> salesInteractionDtos) throws InstantiationException, IllegalAccessException {
		salesInteractionService.saveSalesInteractions(salesInteractionDtos);
	}
	
	
}
