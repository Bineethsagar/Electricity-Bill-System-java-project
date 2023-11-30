package com.electricity.billing.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.billing.system.dto.CustomerRequestDto;
import com.electricity.billing.system.dto.ErrorResponseDto;
import com.electricity.billing.system.service.CustomerService;

@RestController
public class Customer_Controller {

	@Autowired
	CustomerService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveCustomerDetails(@RequestBody CustomerRequestDto request){
		
		ErrorResponseDto response = new ErrorResponseDto();
		
		return service.saveCustomerDetails(request);	
		
	}
}
