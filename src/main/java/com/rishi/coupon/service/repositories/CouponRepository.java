package com.rishi.coupon.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.coupon.service.entities.CouponEntity;

public interface CouponRepository extends JpaRepository<CouponEntity, Long>{
	
	public CouponEntity findByCode(String code);

}
