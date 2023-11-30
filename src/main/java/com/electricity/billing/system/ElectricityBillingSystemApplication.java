package com.electricity.billing.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com" })
@EntityScan("com.electricity.billing.system.entity")
@EnableJpaRepositories("com")
public class ElectricityBillingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillingSystemApplication.class, args);
	}

}
