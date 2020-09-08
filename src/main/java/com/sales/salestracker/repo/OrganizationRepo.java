/**
 * 
 */
package com.sales.salestracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.salestracker.entity.Organization;

/**
 * @author cchaubey
 *
 */
@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long> {

}
