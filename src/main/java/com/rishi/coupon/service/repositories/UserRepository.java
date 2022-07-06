package com.rishi.coupon.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.coupon.service.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByEmail(String email);

}
