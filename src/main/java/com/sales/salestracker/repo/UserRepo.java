package com.sales.salestracker.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.salestracker.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public Optional<User> findByUserNameAndPassword(String userName, String password);

}
