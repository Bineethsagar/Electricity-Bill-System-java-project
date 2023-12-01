package com.electricity.billing.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.billing.system.dto.CustomerRequestDto;
import com.electricity.billing.system.dto.ErrorResponseDto;
import com.electricity.billing.system.dto.LoginRequestDto;
import com.electricity.billing.system.entity.CustomerModel;
import com.electricity.billing.system.service.CustomerService;
import com.electricity.billing.system.util.Constants;

@RestController
public class Customer_Controller {

	@Autowired
	CustomerService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveCustomerDetails(@RequestBody CustomerRequestDto request){
		CustomerModel model = new CustomerModel();
		ErrorResponseDto response = new ErrorResponseDto();

			if(request.getPassword().equals( request.getConfirmPassword())) {
				return service.saveCustomerDetails(request);		
			}else {
				response.setError_code(Constants.EBS105);
				response.setError_message(Constants.PASSWORD_AND_CONFIRMPASSWORD_NOT_MATCHED);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);		
			}
}
	@GetMapping("/login")
	public ResponseEntity<?> loginRequest(@RequestBody LoginRequestDto request) {
		
		return service.loginRequest(request);
		
	}
	@GetMapping("/findByMeterNumber/{meterNumber}")
	public ResponseEntity<?> findCustomerByMeterDetails(@PathVariable String meterNumber) {
		
		
		return service.findCustomerByMeterDetails(meterNumber);

}
}
