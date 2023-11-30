package com.electricity.billing.system.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginRequestDto {
	
	private String userName;
	private String email;
	private String password;

}
