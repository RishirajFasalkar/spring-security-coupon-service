package com.rishi.coupon.service.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.coupon.service.dtos.CouponDto;
import com.rishi.coupon.service.entities.CouponEntity;
import com.rishi.coupon.service.repositories.CouponRepository;

@Service
public class CouponService {
	
	@Autowired
	CouponRepository couponRepository;
	
	public CouponDto createCoupon(CouponDto couponDto) {
		CouponEntity couponEntity = new CouponEntity();
		BeanUtils.copyProperties(couponDto, couponEntity);
		CouponEntity fetchedCouponEntity = couponRepository.save(couponEntity);
		BeanUtils.copyProperties(fetchedCouponEntity, couponDto);
		return couponDto;
	}

	public CouponDto findByCode(String code) {
		CouponDto couponDto = new CouponDto();
		BeanUtils.copyProperties(couponRepository.findByCode(code), couponDto);
		return couponDto;
	}

}
