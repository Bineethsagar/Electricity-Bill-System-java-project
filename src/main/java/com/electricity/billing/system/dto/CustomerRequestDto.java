package com.electricity.billing.system.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerRequestDto {

	private String customerName;
	
	private String meterNumber;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String Email;
	
	private String phoneNumber;

}
