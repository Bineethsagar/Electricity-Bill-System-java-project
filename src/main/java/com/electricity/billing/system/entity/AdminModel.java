package com.electricity.billing.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "admin_access")
public class AdminModel {

	@Id
	 private String username;
	 private String password;
}
