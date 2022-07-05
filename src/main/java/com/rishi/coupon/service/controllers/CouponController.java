package com.rishi.coupon.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.coupon.service.dtos.CouponDto;
import com.rishi.coupon.service.services.CouponService;

@RestController
@RequestMapping("/couponapi")
public class CouponController {
	
	@Autowired
	CouponService couponService;
	
	@PostMapping("/coupon")
	public CouponDto createCoupon(@RequestBody CouponDto couponDto) {
		
		return couponService.createCoupon(couponDto);
	}
	
	@GetMapping("/coupon/{code}")
	public CouponDto getCoupon(@PathVariable String code) {
		
		return couponService.findByCode(code);
	}

}
