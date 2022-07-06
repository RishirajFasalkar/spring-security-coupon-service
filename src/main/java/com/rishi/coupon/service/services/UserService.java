package com.rishi.coupon.service.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.coupon.service.dtos.RoleDto;
import com.rishi.coupon.service.dtos.UserDto;
import com.rishi.coupon.service.entities.RoleEntity;
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
		//BeanUtils.copyProperties doesn't work for roles coz entity has Set<RoleEntity> and dto has Set<RoleDto>
		//so below code
		Set<RoleDto> roleDtos = new HashSet<RoleDto>();
		for (RoleEntity roleEntity : userEntity.getRoles()) {
			RoleDto roleDto = new RoleDto();
			roleDto.setName(roleEntity.getName());
			roleDtos.add(roleDto);
		}
		userDto.setRoles(roleDtos);
		return userDto;
	}

}
