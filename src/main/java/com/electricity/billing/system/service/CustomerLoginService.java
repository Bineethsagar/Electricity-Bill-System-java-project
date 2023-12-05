package com.electricity.billing.system.service;

import org.springframework.http.ResponseEntity;

import com.electricity.billing.system.dto.LoginRequestDto;

public interface CustomerLoginService {
	
	ResponseEntity<?> loginRequest(LoginRequestDto request);


}
