package com.furniture.service;


import java.util.List;

import com.furniture.exception.PaymentNotFoundException;
import com.furniture.model.Payment;

public interface PaymentService {
	public Payment addPayment(Payment payment);
	public Payment updatePayment(Payment payment)throws PaymentNotFoundException;
	public boolean deletePaymentById(Integer paymentId);
	public List<Payment> getAllPaymentDetails();
	Payment removePayment(long id) throws PaymentNotFoundException;
	Payment getPaymentById(Integer paymentId) throws PaymentNotFoundException;


}
	
	