package com.electricity.billing.system.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.electricity.billing.system.dto.CustomerRequestDto;
import com.electricity.billing.system.dto.ErrorResponseDto;
import com.electricity.billing.system.dto.LoginRequestDto;
import com.electricity.billing.system.entity.CustomerModel;
import com.electricity.billing.system.service.CustomerLoginService;
import com.electricity.billing.system.service.CustomerService;
import com.electricity.billing.system.util.Constants;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class CustomerController {
	
	static final Logger LOGGER = LogManager.getLogger(CustomerController.class);

	@Autowired
	CustomerService service;
	
	@Autowired
	CustomerLoginService loginService;
	
	@GetMapping("/register")
	public ResponseEntity<?> customerRegister( @RequestBody CustomerRequestDto request){
		log.info("In CustomerController customerRegister() with request :" + request);
		CustomerModel model = new CustomerModel();
		ErrorResponseDto response = new ErrorResponseDto();

			if(request.getPassword().equals( request.getConfirmPassword())) {
				return service.customerRegister(request);		
			}else {
				response.setError_code(Constants.EBS105);
				response.setError_message(Constants.PASSWORD_AND_CONFIRMPASSWORD_NOT_MATCHED);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);		
			}
}
	@GetMapping("/login")
	public ResponseEntity<?> loginRequest(@RequestBody LoginRequestDto request) {
		log.info("In CustomerController loginRequest() with request :" + request);
		return loginService.loginRequest(request);
		
	}
	@GetMapping("/findByMeterNumber/{meterNumber}")
	public ResponseEntity<?> findCustomerByMeterDetails(@PathVariable String meterNumber) {
		log.info("In CustomerController findCustomerByMeterDetails() with request :" + meterNumber);
		return service.findCustomerByMeterDetails(meterNumber);
}
}
