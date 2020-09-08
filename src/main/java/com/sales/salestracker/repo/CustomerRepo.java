/**
 * 
 */
package com.sales.salestracker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.salestracker.entity.Customer;

/**
 * @author cchaubey
 *
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	List<Customer> findByOrganizationID(Long organizationID);

}
