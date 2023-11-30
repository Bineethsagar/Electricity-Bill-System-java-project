package com.electricity.billing.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.electricity.billing.system.dto.CustomerRequestDto;
import com.electricity.billing.system.dto.ErrorResponseDto;
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
			model.setCustomerName(request.getCustomerName());
			model.setEmail(request.getEmail());
			model.setAddress(request.getAddress());
			model.setCity(request.getCity());
			model.setMeterNumber(request.getMeterNumber());
			model.setPhoneNumber(request.getPhoneNumber());
			model.setState(request.getState());
			
			repository.save(model);
			response.setError_code(Constants.EBS200);
			response.setError_message(Constants.SUCCESS);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		}catch(Exception e){
			response.setError_code(Constants.EBS100);
			response.setError_message(Constants.FAILED);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}
