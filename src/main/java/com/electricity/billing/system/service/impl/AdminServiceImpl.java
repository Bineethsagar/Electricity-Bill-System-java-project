package com.electricity.billing.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.billing.system.entity.AdminModel;
import com.electricity.billing.system.repository.AdminRepository;
import com.electricity.billing.system.service.AdminService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository repository;
	
	@Override
	public boolean authenticate(String username, String password) {
		log.info("In AdminServiceImpl authenticate() with request :" + username);
		 AdminModel admin = repository.findById(username).orElse(null);
	     return admin != null && admin.getPassword().equals(password);
	    }

}
