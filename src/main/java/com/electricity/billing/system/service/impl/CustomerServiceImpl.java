package com.electricity.billing.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.electricity.billing.system.dto.CustomerRequestDto;
import com.electricity.billing.system.dto.ErrorResponseDto;
import com.electricity.billing.system.dto.LoginRequestDto;
import com.electricity.billing.system.entity.CustomerModel;
import com.electricity.billing.system.repository.CustomerRepository;
import com.electricity.billing.system.service.CustomerService;
import com.electricity.billing.system.util.Constants;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository repository;

	@Override
	public ResponseEntity<?> saveCustomerDetails(CustomerRequestDto request) {

		ErrorResponseDto response = new ErrorResponseDto();
		CustomerModel model = new CustomerModel();
		try 
		{
			model.setUserName(request.getUserName());
			model.setEmail(request.getEmail());
			model.setPassword(request.getPassword());
			model.setConfirmPassword(request.getConfirmPassword());
			model.setAddress(request.getAddress());
			model.setCity(request.getCity());
			model.setMeterNumber(request.getMeterNumber());
			model.setPhoneNumber(request.getPhoneNumber());
			model.setState(request.getState());
				
			repository.save(model);
			response.setError_code(Constants.EBS200);
			response.setError_message(Constants.SUCCESS);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}catch(Exception ex){
			response.setError_code(Constants.EBS100);
			response.setError_message(Constants.FAILED);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);	
		}
	}

	@Override
	public ResponseEntity<?> loginRequest(LoginRequestDto request) {
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

	@Override
	public ResponseEntity<?> findCustomerByMeterDetails(String meterNumber) {

		ErrorResponseDto response = new ErrorResponseDto();
		
		try {
			CustomerModel model = repository.findByMeterNumber(meterNumber);

			if(model!=null) {
				response.setError_code(Constants.EBS106);
				response.setError_message(Constants.USER_DETAILS_EXISTS);
				return ResponseEntity.ok(repository.findByMeterNumber(meterNumber));
				
			}else {
				response.setError_code(Constants.EBS107);
				response.setError_message(Constants.USER_DETAILS_NOT_FOUND);
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response + e.getMessage());
		}
	}	
}

