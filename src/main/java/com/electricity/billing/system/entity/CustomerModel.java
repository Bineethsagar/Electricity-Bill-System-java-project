package com.electricity.billing.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer_Details")
public class CustomerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "customer_name")
	private String userName;
	
	@Column(name = "meter_number")
	private String meterNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "confirm_password")
	private String confirmPassword;
	
	@Column(name = "phone_number")
	private String phoneNumber;

}