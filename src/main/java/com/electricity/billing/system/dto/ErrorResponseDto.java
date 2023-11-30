package com.electricity.billing.system.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorResponseDto {

	private String error_code;
	private String error_message;

}
