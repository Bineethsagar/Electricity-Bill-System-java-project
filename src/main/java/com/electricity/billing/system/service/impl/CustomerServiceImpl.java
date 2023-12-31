package com.electricity.billing.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;
import com.electricity.billing.system.dto.CustomerRequestDto;
import com.electricity.billing.system.dto.ErrorResponseDto;
import com.electricity.billing.system.entity.CustomerModel;
import com.electricity.billing.system.repository.CustomerRepository;
import com.electricity.billing.system.service.CustomerService;
import com.electricity.billing.system.util.Constants;

@Log4j2
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository repository;

	@Override
	public ResponseEntity<?> customerRegister(CustomerRequestDto request) {
		log.info("In CustomerServiceImpl customerRegister() with request :" + request);
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
			log.error("Error occurred In CustomerServiceImpl customerRegister(): " + ex.getMessage());
			response.setError_code(Constants.EBS100);
			response.setError_message(Constants.FAILED);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);	
		}
	}

	
	@Override
	public ResponseEntity<?> findCustomerByMeterDetails(String meterNumber) {
		log.info("In CustomerServiceImpl findCustomerByMeterDetails() with request :" + meterNumber);
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
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		}catch(Exception e) {
			log.error("Error occurred In CustomerServiceImpl findCustomerByMeterDetails(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response + e.getMessage());
		}
	}	
}

