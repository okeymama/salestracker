/**
 * 
 */
package com.sales.salestracker.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.salestracker.entity.SalesInteraction;

/**
 * @author cchaubey
 *
 */
public interface SalesInteractionRepo extends JpaRepository<SalesInteraction, Long> {

	List<SalesInteraction> findByCreatedDate(Date date);

	List<SalesInteraction> findByCustomerID(Long customerID);

}
