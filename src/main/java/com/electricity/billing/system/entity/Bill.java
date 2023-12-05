package com.electricity.billing.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Bill {
 
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 @JoinColumn(name = "customer_id", nullable = false)
 private CustomerModel customer;

 @Column(nullable = false)
 private int unitsConsumed;

 @Column(nullable = false)
 private double totalAmount;

 @Column(nullable = false)
 private String month;

 
}
