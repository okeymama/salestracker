/**
 * 
 */
package com.sales.salestracker.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.salestracker.dto.OrganizationDto;
import com.sales.salestracker.entity.Organization;
import com.sales.salestracker.repo.OrganizationRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

/**
 * @author cchaubey
 *
 */
@Transactional
@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepo organizationRepo;
	
	public List<OrganizationDto> getAllOrganization() throws InstantiationException, IllegalAccessException {
		List<OrganizationDto> organizationDtos = null;
		List<Organization> organizations = organizationRepo.findAll();
		if(!CollectionUtils.isEmpty(organizations)) {
			organizationDtos = SalestrackerBeanUtil.copyEntityListToDTOList(organizations, OrganizationDto.class);
		}
		return organizationDtos;
	}
	
	public void saveOrganizations(List<OrganizationDto> organizationDtos) throws InstantiationException, IllegalAccessException {
		if(!CollectionUtils.isEmpty(organizationDtos)) {
			List<Organization> organizations = SalestrackerBeanUtil.copyEntityListToDTOList(organizationDtos, Organization.class);
			organizationRepo.saveAll(organizations);
		}
	}
	
}
