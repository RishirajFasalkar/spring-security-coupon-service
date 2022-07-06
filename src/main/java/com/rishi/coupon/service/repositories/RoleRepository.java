package com.rishi.coupon.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.coupon.service.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	

}
