package com.electricity.billing.system.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerRequestDto {

	private String userName;
	
	private String meterNumber;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
	
	private String phoneNumber;

}
