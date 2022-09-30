package com.furniture.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}



