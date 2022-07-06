package com.rishi.coupon.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rishi.coupon.service.dtos.UserDto;
import com.rishi.coupon.service.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("inside loadUserByUsername, username: "+username);
		UserDto userDto = userService.getUserByUserName(username);
		System.out.println("userDto: "+userDto);
		if(userDto == null) {
			throw new UsernameNotFoundException(username+" username not found.");
		}
		return new User(userDto.getEmail(), userDto.getPassword(), userDto.getRoles());
	}

}
