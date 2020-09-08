package com.sales.salestracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.salestracker.dto.FileDto;
import com.sales.salestracker.entity.FileEntity;

@Repository
public interface FileRepo extends JpaRepository<FileEntity, Long>{

	public FileDto findByName(String fileName);

}
