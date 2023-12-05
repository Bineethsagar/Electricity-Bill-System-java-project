package com.electricity.billing.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.electricity.billing.system.dto.ErrorResponseDto;
import com.electricity.billing.system.entity.AdminModel;
import com.electricity.billing.system.service.AdminService;
import com.electricity.billing.system.util.Constants;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class AdminController {
	
	 @Autowired
	 private AdminService adminService;

	 @GetMapping("/admin/login")
	  public ResponseEntity<?> adminlogin(@RequestBody AdminModel loginRequest) {
			log.info("In CustomerController login() with request :" + loginRequest);
 		ErrorResponseDto response = new ErrorResponseDto();
	        if (adminService.authenticate(loginRequest.getUsername(), loginRequest.getPassword())) {
	    		response.setError_code(Constants.EBS200);
	    		response.setError_message(Constants.LOGIN_SUCCESS);
	            return ResponseEntity.status(HttpStatus.CREATED).body(response);
	        } else {
	        	response.setError_code(Constants.EBS100);
	    		response.setError_message(Constants.ADMIN_DETAILS_NO_FOUND);
	            return ResponseEntity.status(HttpStatus.CREATED).body(response);
	        }
	    }
}
