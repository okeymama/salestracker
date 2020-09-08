package com.sales.salestracker.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sales.salestracker.dto.FileResponceDto;
import com.sales.salestracker.service.FileService;



@RestController
@RequestMapping(path = "/File")
public class FileController {

	@Autowired
	private FileService fileService;

	@PostMapping("/upload")
	public void uploadFile(@RequestHeader("id") Long id,@RequestParam("file") MultipartFile file) throws IOException {

		fileService.uploadFile(id,file);
		
	}


	@GetMapping(path = { "/{id}" })

	public void getFile(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {

		FileResponceDto fileResponceDto = fileService.getFile(id);

		ServletOutputStream outStream = response.getOutputStream();
		response.setContentType(fileResponceDto.getType());
		response.setHeader("Content-Disposition", "attachment; filename="+fileResponceDto.getName());
		outStream.write(fileResponceDto.getFile());
		outStream.flush();
	}


	

}
