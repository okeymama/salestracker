package com.sales.salestracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.salestracker.entity.Case;

@Repository
public interface CaseRepo extends JpaRepository<Case, Long> {

}
