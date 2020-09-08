/**
 * 
 */
package com.sales.salestracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.salestracker.entity.Product;

/**
 * @author cchaubey
 *
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
