package com.sales.salestracker.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.salestracker.dto.UserDto;
import com.sales.salestracker.entity.User;
import com.sales.salestracker.service.UserService;

@CrossOrigin(value="*")
@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public ResponseEntity<UserDto> validateUser(@RequestBody UserDto userDto) {
		
		UserDto user = userService.validateUser(userDto.getUserName(),userDto.getPassword());
		
		if(null != user) {
			LOGGER.info("User exists with provided username and password");
			return new ResponseEntity<UserDto>(user, HttpStatus.OK);
		} else {
			LOGGER.info("User doesn't exist with provided username and password");
			return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	@PostMapping("/Users")
	public void saveUsers(List<UserDto> userDtos) throws InstantiationException, IllegalAccessException {
		userService.saveUsers(userDtos);
	}
	

}
