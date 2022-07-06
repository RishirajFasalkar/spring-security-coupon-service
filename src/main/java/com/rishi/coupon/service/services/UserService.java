package com.rishi.coupon.service.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.coupon.service.dtos.UserDto;
import com.rishi.coupon.service.entities.UserEntity;
import com.rishi.coupon.service.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserDto getUserByUserName(String email) { //email is username in our case
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null){
			return null;
		}
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userEntity, userDto);
		return userDto;
	}

}
