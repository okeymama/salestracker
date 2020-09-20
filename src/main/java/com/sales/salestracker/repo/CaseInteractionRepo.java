/**
 * 
 */
package com.sales.salestracker.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sales.salestracker.entity.CaseInteraction;

/**
 * @author cchaubey
 *
 */
@Repository
public interface CaseInteractionRepo extends JpaRepository<CaseInteraction, Long> {

	/*
	 * @Query("Select ci from CaseInteraction ci " +
	 * "where ci.parentCase.caseID =:caseID") List<CaseInteraction>
	 * findByCaseID(@Param("caseID")Long caseID);
	 */

	List<CaseInteraction> findByCreatedDate(Date date);

	/*
	 * @Query("Select caseInteraction from CaseInteraction caseInteraction,SalesCase salesCase,SalesInteraction salesInteraction "
	 * +
	 * "where caseInteraction.parentCase.caseID = salesCase.caseID and salesCase.salesInteraction.salesIntID = salesInteraction.salesIntID "
	 * + "and salesInteraction.customerID=:customerID") List<CaseInteraction>
	 * findByCustomerID(@Param("customerID")String customerID);
	 */
}
