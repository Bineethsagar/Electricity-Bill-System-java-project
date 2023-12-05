package com.electricity.billing.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.electricity.billing.system.dto.ErrorResponseDto;
import com.electricity.billing.system.dto.LoginRequestDto;
import com.electricity.billing.system.entity.CustomerModel;
import com.electricity.billing.system.repository.CustomerRepository;
import com.electricity.billing.system.service.CustomerLoginService;
import com.electricity.billing.system.util.Constants;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerLoginServiceImpl  implements CustomerLoginService{

	@Autowired
	CustomerRepository repository;
	@Override
	public ResponseEntity<?> loginRequest(LoginRequestDto request) {
		log.info("In CustomerLoginServiceImpl loginRequest() with request :" + request);
		ErrorResponseDto response = new ErrorResponseDto();
		CustomerModel customerDetails = null;
		
	try {
		customerDetails = repository.findByEmailAndPassword(request.getEmail(), request.getPassword());
		if(customerDetails == null) {
			response.setError_code(Constants.EBS102);
			response.setError_message(Constants.EMAIL_NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
		}else {
			response.setError_code(Constants.EBS103);
			response.setError_message(Constants.LOGIN_SUCCESS);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response + e.getMessage());
}
}

}
