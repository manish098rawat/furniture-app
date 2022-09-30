package com.furniture.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.Repository.PaymentRepository;
import com.furniture.exception.PaymentNotFoundException;
import com.furniture.model.Payment;
import com.furniture.service.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService {

//	@Autowired
//	private EmailSenderServiceImpl senderService;
	@Autowired
	private PaymentRepository paymentRepo;

	@Override
	public Payment addPayment(Payment payment) {
		return this.paymentRepo.save(payment);

	}

	@Override
	public Payment removePayment(long id) throws PaymentNotFoundException {

		return null;
	}

	@Override
	public Payment updatePayment(Payment payment) throws PaymentNotFoundException {

		Optional<Payment> paymentOpt = this.paymentRepo.findById(payment.getPaymentId());
		if (paymentOpt.isEmpty()) {
			throw new PaymentNotFoundException("Payment id not found");
		}
		Payment updatePayment = paymentOpt.get();
		updatePayment.setCardNumber(payment.getCardNumber());
		updatePayment.setCardName(payment.getCardName());
		updatePayment.setCardExpiry(payment.getCardExpiry());
		updatePayment.setBankName(payment.getBankName());
		updatePayment.setStatus(payment.getStatus());
		return this.paymentRepo.save(updatePayment);

	}

	@Override
	public boolean deletePaymentById(Integer paymentId) {
		this.paymentRepo.deleteById(paymentId);
		return true;
	}

	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentNotFoundException {
		Optional<Payment> paymentOpt = this.paymentRepo.findById(paymentId);
		if (paymentOpt.isEmpty())
			throw new PaymentNotFoundException("Id Not Found");

		return paymentOpt.get();
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		return this.paymentRepo.findAll();
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() throws MessagingException {
//		senderService.sendSimpleEmail("manishraw098@gmail.com", "This is email body", "This is email subject");
//	}

}
