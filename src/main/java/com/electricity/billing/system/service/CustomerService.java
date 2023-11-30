package com.electricity.billing.system.service;

import org.springframework.http.ResponseEntity;

import com.electricity.billing.system.dto.CustomerRequestDto;
import com.electricity.billing.system.dto.LoginRequestDto;

public interface CustomerService {

	ResponseEntity<?> saveCustomerDetails(CustomerRequestDto request);
	ResponseEntity<?> loginRequest(LoginRequestDto request);
}
