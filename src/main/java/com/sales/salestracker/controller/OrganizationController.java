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

import com.sales.salestracker.dto.OrganizationDto;
import com.sales.salestracker.service.OrganizationService;

/**
 * @author cchaubey
 *
 */
@CrossOrigin(value="*")
@RestController
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	
	@GetMapping("/Organizations")
	public List<OrganizationDto> getAllOrganization() throws InstantiationException, IllegalAccessException{
		return organizationService.getAllOrganization();
	}
	
	@PostMapping("/Organizations")
	public void saveOrganizations(@RequestBody List<OrganizationDto> organizationDtos) throws InstantiationException, IllegalAccessException {
		organizationService.saveOrganizations(organizationDtos);
	}
	
}
