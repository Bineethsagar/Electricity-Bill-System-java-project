package com.electricity.billing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electricity.billing.system.entity.AdminModel;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, String> {

}
