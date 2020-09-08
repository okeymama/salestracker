/**
 * 
 */
package com.sales.salestracker.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.salestracker.entity.CaseInteraction;

/**
 * @author cchaubey
 *
 */
@Repository
public interface CaseInteractionRepo extends JpaRepository<CaseInteraction, Long> {

	List<CaseInteraction> findByCaseID(Long caseID);

	List<CaseInteraction> findByDate(Date date);

	List<CaseInteraction> findByCustomerID(Long customerID);

}
