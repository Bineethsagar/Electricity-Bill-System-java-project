package com.electricity.billing.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.billing.system.entity.Bill;
import com.electricity.billing.system.entity.CustomerModel;
import com.electricity.billing.system.repository.BillRepository;
import com.electricity.billing.system.repository.CustomerRepository;
import com.electricity.billing.system.service.BillService;
import com.electricity.billing.system.util.CustomerNotFoundException;

import lombok.extern.log4j.Log4j2;

//BillServiceImpl.java
@Log4j2
@Service
public class BillServiceImpl implements BillService {

 @Autowired
 private CustomerRepository customerRepository;

 @Autowired
 private BillRepository billRepository;

 @Override
 public void generateBill(String meterNumber, String month) throws CustomerNotFoundException {
		log.info("In BillServiceImpl generateBill() with request :" + meterNumber,month);
	 // Fetch customer details
     CustomerModel customer = customerRepository.findByMeterNumber(meterNumber);

     if (customer != null) {
         // Calculate consumption (You may get this from the meter or other sources)
         int unitsConsumed = calculateUnitsConsumed();

         // Apply tariffs and calculate total amount
         double totalAmount = calculateTotalAmount(unitsConsumed);

         // Create a new bill
         Bill bill = new Bill();
         bill.setCustomer(customer);
         bill.setUnitsConsumed(unitsConsumed);
         bill.setTotalAmount(totalAmount);
         bill.setMonth(month);

         // Save the bill to the database
         billRepository.save(bill);
     } else {
         throw new CustomerNotFoundException("Customer not found for meter number: " + meterNumber);
     }
 }

 private double calculateTotalAmount(int unitsConsumed) {
     double billToPay = 0;

     // check whether units are less than 100
     if (unitsConsumed < 100) {
         billToPay = unitsConsumed * 1.20;
     }
     // check whether the units are less than 300
     else if (unitsConsumed < 300) {
         billToPay = 100 * 1.20 + (unitsConsumed - 100) * 2;
     }
     // check whether the units are greater than 300
     else {
         billToPay = 100 * 1.20 + 200 * 2 + (unitsConsumed - 300) * 3;
     }
     return billToPay;
 }

 private int calculateUnitsConsumed() {
     // In a real scenario, you might fetch this from the meter or another source
     return 380;
 }
}

