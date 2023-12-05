package com.electricity.billing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electricity.billing.system.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
