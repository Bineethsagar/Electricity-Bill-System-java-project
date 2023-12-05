package com.electricity.billing.system.service;

import com.electricity.billing.system.util.CustomerNotFoundException;

public interface BillService {
 void generateBill(String meterNumber, String month) throws CustomerNotFoundException;
}

