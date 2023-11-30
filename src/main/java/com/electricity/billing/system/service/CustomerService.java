package com.electricity.billing.system.service;

import org.springframework.http.ResponseEntity;

import com.electricity.billing.system.dto.CustomerRequestDto;
import com.electricity.billing.system.dto.ErrorResponseDto;

public interface CustomerService {

	ResponseEntity<?> saveCustomerDetails(CustomerRequestDto request);
}
