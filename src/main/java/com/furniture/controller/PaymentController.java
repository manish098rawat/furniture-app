package com.furniture.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.exception.PaymentNotFoundException;
import com.furniture.model.Payment;
import com.furniture.service.PaymentService;


@RestController
@RequestMapping("payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("add")
	public Payment addPayment(@Valid @RequestBody Payment payment) {
		return this.paymentService.addPayment(payment);

	}

	@PutMapping("update")
	public Payment updatePayment(@RequestBody Payment payment) throws PaymentNotFoundException {
		return this.paymentService.updatePayment(payment);
	}

	@DeleteMapping("delete/{paymentId}")
	public boolean deletePaymentById(@PathVariable("paymentId") Integer paymentId) throws PaymentNotFoundException {
		return this.paymentService.deletePaymentById(paymentId);
	}

	@GetMapping("getby/{id}")
	public Payment getpaymentById(@PathVariable("id") Integer paymentId) throws PaymentNotFoundException {
		return this.paymentService.getPaymentById(paymentId);
	}

	@GetMapping("showAll")
	public List<Payment> getAllPaymentDetails() {
		return this.paymentService.getAllPaymentDetails();
	}

}
