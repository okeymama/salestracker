package com.sales.salestracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.salestracker.entity.SalesCase;

@Repository
public interface SalesCaseRepo extends JpaRepository<SalesCase, Long> {

}
