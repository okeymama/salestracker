package com.sales.salestracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity(name="mst_file")
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "picByte")
	private byte[] picByte;

	
	public FileEntity(String originalFilename, String contentType, byte[] picByte) {
		this.name = originalFilename;
		this.type = contentType;
		this.picByte = picByte;
	}
}
