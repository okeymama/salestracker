package com.sales.salestracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.salestracker.dto.UserDto;
import com.sales.salestracker.entity.User;
import com.sales.salestracker.repo.UserRepo;
import com.sales.salestracker.util.SalestrackerBeanUtil;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepository;

	
	public UserDto validateUser(String userName, String password) {
		UserDto userDto = new UserDto();
		Optional<User> user = userRepository.findByUserNameAndPassword(userName,password);
		if(user.isPresent()) {
			SalestrackerBeanUtil.copyProperties(user, userDto);
		}
		return userDto;
	}


	public void saveUsers(List<UserDto> userDtos) throws InstantiationException, IllegalAccessException {
		List<User> users = SalestrackerBeanUtil.copyEntityListToDTOList(userDtos, User.class);
		userRepository.saveAll(users);
	}
	
	

}
