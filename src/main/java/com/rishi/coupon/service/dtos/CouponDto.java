package com.rishi.coupon.service.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CouponDto {
	
	private long id;
	private String code;
	private BigDecimal discount;
	private String expDate;

}
