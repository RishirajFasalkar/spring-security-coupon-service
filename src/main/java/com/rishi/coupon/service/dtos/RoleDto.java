package com.rishi.coupon.service.dtos;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

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
public class RoleDto implements GrantedAuthority{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Set<UserDto> userDtos;

	@Override
	public String getAuthority() {
		return name;
	}

}
